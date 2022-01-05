package ru.gaivor.weather.communication;


import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.gaivor.weather.dto.WeatherDto;

import java.time.LocalDate;

@Component
public class Communication {

    private RestTemplate restTemplate = new RestTemplate();
    private final String URL = "https://api.weather.yandex.ru/v2/forecast?lat=60.005167&lon=30.229082";

    public WeatherDto getWeatherFromYandex() {
        WeatherDto weatherDto = new WeatherDto();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Yandex-API-Key", "a9dc98ef-6d37-437e-9c7b-d8c0d32aed35");
        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> weatherFromYandex = restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class);
        String forParsing = weatherFromYandex.getBody();
        String searchedString = forParsing.substring(forParsing.indexOf("uptime"),
                (forParsing.indexOf("uptime") + 27));
        String temperature = String.valueOf(searchedString.charAt(searchedString.length() - 1));
        weatherDto.setValue(temperature);
        weatherDto.setDate(LocalDate.now());

        return weatherDto;
    }
}
