package ru.gaivor.weather.service;

import org.springframework.stereotype.Service;
import ru.gaivor.weather.communication.Communication;
import ru.gaivor.weather.entity.Weather;
import ru.gaivor.weather.repository.WeatherRepository;

import java.util.List;

@Service
public class GenericWeatherService implements WeatherService {

    private final Communication communication;
    private final WeatherRepository weatherRepository;

    public GenericWeatherService(Communication communication, WeatherRepository weatherRepository) {
        this.communication = communication;
        this.weatherRepository = weatherRepository;
    }


    @Override
    public String getLatestTemperatureFromDB() {
        Weather weather = new Weather();
        weather.setDate(communication.getWeatherFromYandex().getDate());
        weather.setValue(communication.getWeatherFromYandex().getValue());
        save(weather);
        return weatherRepository.getLatestTemperature();
    }

    //public List<Weather> getWeatherHistory() {
//        return weatherRepository.findAll();
//    }

    public void save(Weather weather) {
        weatherRepository.save(weather);
    }

}
