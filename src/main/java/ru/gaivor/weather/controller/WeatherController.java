package ru.gaivor.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gaivor.weather.service.WeatherService;



@RestController
public class WeatherController {

    WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getTemperature() {
        String weatherFromDB = weatherService.getLatestTemperatureFromDB();
        return "Current temperature in Saint-Petersburg is " +  weatherFromDB + " degrees Celsius";
    }
}
