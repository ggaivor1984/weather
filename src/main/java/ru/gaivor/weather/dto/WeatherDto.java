package ru.gaivor.weather.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class WeatherDto {
    private String value;
    private LocalDate date;
}
