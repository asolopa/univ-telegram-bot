package com.thevoodoohuman.telegrambot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrentWeatherDTO {
    String sky;
    int temperature;
    double temperatureFeelsLike;
    int temperatureMin;
    int temperatureMax;
    int pressure;
    int humidity;
    int visibility;
    double windSpeed;
    String country;
    @JsonProperty("name")
    String cityName;

    @SuppressWarnings("unchecked")
    @JsonProperty("weather")
    private void unpackNestedWeather(ArrayList<Map<String, Object>> weather) {
        this.sky = (String) weather.get(0).get("description");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("main")
    private void unpackNestedMain(Map<String, Object> main) {
        this.temperature = (int) main.get("temp");
        this.temperatureFeelsLike = (double) main.get("feels_like");
        this.temperatureMin = (int) main.get("temp_min");
        this.temperatureMax = (int) main.get("temp_max");
        this.pressure = (int) main.get("pressure");
        this.humidity = (int) main.get("humidity");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("wind")
    private void unpackNestedWind(Map<String, Object> wind) {
        this.windSpeed = (double) wind.get("speed");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("sys")
    private void unpackNestedSys(Map<String, Object> sys) {
        this.country = (String) sys.get("country");
    }
}
