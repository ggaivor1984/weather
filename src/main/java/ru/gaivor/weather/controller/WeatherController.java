package ru.gaivor.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gaivor.weather.communication.Communication;
import ru.gaivor.weather.dto.WeatherDto;
import ru.gaivor.weather.entity.Weather;
import ru.gaivor.weather.service.WeatherService;

import java.util.List;

@RestController
@RequestMapping
public class WeatherController {

    @Autowired
    WeatherService weatherService;
    @Autowired
    Communication communication;

    @GetMapping("/weather")
    public String getWeather() {
        Weather weather = new Weather();
        weather.setDate(communication.getWeatherFromYandex().getDate());
        weather.setValue(communication.getWeatherFromYandex().getValue());
        weatherService.save(weather);
        List<Weather> weatherHistory = weatherService.getWeatherHistory();
        return "Current temperature in Saint-Petersburg is " + weatherHistory.get(weatherHistory.size() - 1).getValue()
                + " degrees Celsius";
    }
}
