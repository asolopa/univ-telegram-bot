package com.thevoodoohuman.telegrambot.service;

import com.thevoodoohuman.telegrambot.model.CurrentWeatherDTO;
/**
 * @author asolopa
 */
public interface CurrentWeatherService {

    CurrentWeatherDTO getCurrentForecast(double lon, double lat);




}
