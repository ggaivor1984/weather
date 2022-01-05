package ru.gaivor.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gaivor.weather.communication.Communication;

@SpringBootApplication
public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }
}
