package com.thevoodoohuman.telegrambot.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thevoodoohuman.telegrambot.model.CurrentWeatherDTO;
import com.thevoodoohuman.telegrambot.service.CurrentWeatherService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/**
 * @author asolopa
 */
@Service
@RequiredArgsConstructor
public class CurrentWeatherServiceImpl implements CurrentWeatherService {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Value("${openweathermap.token}")
    private String openWeatherToken;

    @Override
    @SneakyThrows
    public CurrentWeatherDTO getCurrentForecast(double lon, double lat) {
        URI uri = URI.create("http://api.openweathermap.org/data/2.5/weather?units=metric"
                + "&appid=" + openWeatherToken
                + "&lat=" + lat
                + "&lon=" + lon);
        var request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), CurrentWeatherDTO.class);
    }
}
