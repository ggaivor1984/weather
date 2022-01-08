package ru.gaivor.weather.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gaivor.weather.communication.Communication;
import ru.gaivor.weather.entity.Weather;
import ru.gaivor.weather.repository.WeatherRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GenericWeatherServiceTest {
    @Mock
    WeatherRepository weatherRepository;
    GenericWeatherService underTest;
    Communication communication;
    Weather weather;

    @BeforeEach
    void setUp() {
        communication = new Communication();
        weather = new Weather();
        underTest = new GenericWeatherService(communication, weatherRepository);
    }

    @Test
    void canGetLatestTemperatureFromDB() {
        weather.setDate(communication.getWeatherFromYandex().getDate());
        weather.setValue(communication.getWeatherFromYandex().getValue());
        underTest.getLatestTemperatureFromDB();
        verify(weatherRepository, times(1)).save(weather);
        verify(weatherRepository, times(1)).getLatestTemperature();

    }
}