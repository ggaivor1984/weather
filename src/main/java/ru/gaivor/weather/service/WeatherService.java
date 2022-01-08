package ru.gaivor.weather.service;

import ru.gaivor.weather.entity.Weather;

import java.util.List;

public interface WeatherService {
    String getLatestTemperatureFromDB();

   // List<Weather> getWeatherHistory();

    void save(Weather weather);
}
