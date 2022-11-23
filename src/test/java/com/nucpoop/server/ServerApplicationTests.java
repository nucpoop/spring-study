package com.nucpoop.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nucpoop.server.api.WeatherAPI;
import com.nucpoop.server.entity.UltraShortWeather;
import com.nucpoop.server.entity.UltraShortWeather.WeatherRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ServerApplicationTests {

}
