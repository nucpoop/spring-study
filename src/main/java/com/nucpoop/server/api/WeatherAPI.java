package com.nucpoop.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nucpoop.server.dto.request.WeatherRequest;
import com.nucpoop.server.util.MultiValueMapConverter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

@Component
public class WeatherAPI {

    private static final String URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0";
    public static final String GET_ULTRA_SHORT_CST = "/getUltraSrtNcst";
    private final WebClient webClient;
    private final ObjectMapper objectMapper;


    public WeatherAPI(Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.baseUrl(URL).build();
        this.objectMapper = objectMapper;
    }

    public String callAPI(WeatherRequest request, String subUrl) {
        MultiValueMap<String, String> params = MultiValueMapConverter.convert(objectMapper, request);
        System.out.println(params);

        Mono<String> result = webClient.get()
            .uri(
                uriBuilder -> uriBuilder.path(subUrl).queryParams(params).build()
            )
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(String.class);

        System.out.println(result.flux().toStream().findFirst());

        return "";
    }


}
