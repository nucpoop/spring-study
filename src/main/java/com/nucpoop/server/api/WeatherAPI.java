package com.nucpoop.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nucpoop.server.entity.UltraShortWeather;
import com.nucpoop.server.util.MultiValueMapConverter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

@Component
public class WeatherAPI {

    private static final String URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0";
    public static final String GET_ULTRA_SHORT_CST = "/getUltraSrtNcst";
    private final WebClient webClient;
    private final ObjectMapper objectMapper;


    public WeatherAPI(Builder webClientBuilder, ObjectMapper objectMapper) {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(URL);
        factory.setEncodingMode(EncodingMode.VALUES_ONLY);
        this.webClient = webClientBuilder.uriBuilderFactory(factory).baseUrl(URL).build();
        this.objectMapper = objectMapper;
    }

    public UltraShortWeather.WeatherResponse callAPI(UltraShortWeather.WeatherRequest request,
        String subUrl) {
        MultiValueMap<String, String> params = MultiValueMapConverter.convert(objectMapper,
            request);

        return webClient.get()
            .uri(
                uriBuilder -> uriBuilder.path(subUrl).queryParams(params).build()
            )
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(UltraShortWeather.WeatherResponse.class)
            .block();
    }
}
