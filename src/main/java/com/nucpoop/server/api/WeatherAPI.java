package com.nucpoop.server.api;

import com.nucpoop.server.dto.request.WeatherRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WeatherAPI {
    private static final String URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0";
    public static final String GET_ULTRA_SHORT_CST = "/getUltraSrtNcst";
    private final WebClient webClient;


    public WeatherAPI(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(URL).build();
    }

    public String callAPI(WeatherRequest request, String subUrl){

//        webClient.get()
//            .uri(
//                uriBuilder -> uriBuilder.path(subUrl)
//                    .queryParams()
//            )
//            .accept(MediaType.APPLICATION_JSON)
//            .

        return "";
    }


}
