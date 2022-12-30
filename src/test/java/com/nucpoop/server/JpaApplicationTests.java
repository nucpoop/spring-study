package com.nucpoop.server;

import static org.assertj.core.api.Assertions.assertThat;

import com.nucpoop.server.entity.WeatherExample;
import com.nucpoop.server.repository.WeatherExampleRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class JpaApplicationTests {

    @Autowired
    WeatherExampleRepository weatherExampleRepository;

    @BeforeEach
    void initInsertTestData() {
        WeatherExample weatherExample = new WeatherExample();
        weatherExample.setLocation("seoul");
        weatherExampleRepository.save(weatherExample);
    }

    @Test
    void findAllTest() {
        List<WeatherExample> weatherExampleList = weatherExampleRepository.findAll();

        assertThat(weatherExampleList.get(0).getId()).isNotNull();
        assertThat(weatherExampleList.get(0).getLocation()).isEqualTo("seoul");
    }

    @Test
    void findByLocationTest(){
        List<WeatherExample> results = weatherExampleRepository.findByLocation("seoul");

        assertThat(results.get(0).getId()).isNotNull();
        assertThat(results.get(0).getLocation()).isEqualTo("seoul");
    }

    @Test
    void updateTest(){
        List<WeatherExample> results = weatherExampleRepository.findByLocation("seoul");
        results.get(0).setLocation("paris");
        weatherExampleRepository.save(results.get(0));

        assertThat(weatherExampleRepository.findByLocation("paris").get(0).getLocation()).isEqualTo("paris");
    }

}
