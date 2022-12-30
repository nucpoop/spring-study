package com.nucpoop.server.repository;

import com.nucpoop.server.entity.WeatherExample;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherExampleRepository extends JpaRepository<WeatherExample, Long> {
    List<WeatherExample> findByLocation(String location);
}
