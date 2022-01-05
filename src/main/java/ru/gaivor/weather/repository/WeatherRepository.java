package ru.gaivor.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gaivor.weather.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
