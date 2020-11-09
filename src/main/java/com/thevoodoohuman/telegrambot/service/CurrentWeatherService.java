package com.thevoodoohuman.telegrambot.service;

import com.thevoodoohuman.telegrambot.model.CurrentWeatherDTO;

public interface CurrentWeatherService {

    CurrentWeatherDTO getCurrentForecast(double lon, double lat);




}
