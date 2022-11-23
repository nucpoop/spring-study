package com.nucpoop.server;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.nucpoop.server.api.WeatherAPI;
import com.nucpoop.server.entity.UltraShortWeather;
import com.nucpoop.server.entity.UltraShortWeather.WeatherRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WeatherAPI weatherAPI;

    @Test
    void callApiTest() {

        //given
        LocalDate localDate = LocalDate.now();
        UltraShortWeather weather = new UltraShortWeather();
        weather.setRequest(new WeatherRequest(1, 1000, "JSON", localDate.format(
            DateTimeFormatter.ofPattern("yyyyMMdd")), "1200", 55, 127));

        assertThat(weather.getRequest().getServiceKey())
            .isEqualTo("In700GpDhOczBBTNPW9EKqfV2XwqE5ff7638azwe2D9uetiEFgIRLsnK%2FIwzUVJc0xorUJOma6aR4bKJYRu7uQ%3D%3D");

        //when
        UltraShortWeather.WeatherResponse result = weatherAPI.callAPI(weather.getRequest(),
            WeatherAPI.GET_ULTRA_SHORT_CST);

        //then
        assertThat(result.response.header.resultCode)
            .isEqualTo("00");
        assertThat(result.response.header.resultMsg)
            .isEqualTo("NORMAL_SERVICE");
    }
}
