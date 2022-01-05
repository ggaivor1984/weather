package ru.gaivor.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gaivor.weather.entity.Weather;
import ru.gaivor.weather.repository.WeatherRepository;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    public List<Weather> getWeatherHistory() {
        return weatherRepository.findAll();
    }

    public void save(Weather weather) {
        weatherRepository.save(weather);
    }

}
