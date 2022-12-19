package com.nucpoop.server.service;

import com.nucpoop.server.entity.WeatherExample;
import com.nucpoop.server.repository.WeatherExampleRepository;
import java.util.List;

public class WeatherServiceImpl implements WeatherService {

    private final WeatherExampleRepository weatherExampleRepository;

    public WeatherServiceImpl(WeatherExampleRepository weatherExampleRepository) {
        this.weatherExampleRepository = weatherExampleRepository;
    }

    public List<WeatherExample> findAllWeatherExample() {
        return weatherExampleRepository.findAll();
    }
}
