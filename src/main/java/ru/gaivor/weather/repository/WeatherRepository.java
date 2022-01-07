package ru.gaivor.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gaivor.weather.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    @Query(
            value = "SELECT w.value FROM Weather w WHERE w.id = (select MAX(w.id) from Weather w)"
    )
    public String getLatestTemperature();
}
