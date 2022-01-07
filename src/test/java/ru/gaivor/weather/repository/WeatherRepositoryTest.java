package ru.gaivor.weather.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.gaivor.weather.entity.Weather;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class WeatherRepositoryTest {
    @Autowired
    WeatherRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void shouldReturnLatestTemperature() {
        Weather weather = new Weather();
        weather.setValue("22");
        weather.setDate(LocalDate.now());
        underTest.save(weather);
        String test = underTest.getLatestTemperature();
        assertEquals("22", test);
    }
}