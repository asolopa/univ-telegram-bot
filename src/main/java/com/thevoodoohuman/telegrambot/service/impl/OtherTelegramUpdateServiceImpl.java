package com.thevoodoohuman.telegrambot.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thevoodoohuman.telegrambot.model.CurrentWeatherDTO;
import com.thevoodoohuman.telegrambot.service.CurrentWeatherService;
import com.thevoodoohuman.telegrambot.service.OtherTelegramUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.net.http.HttpClient;

/**
 * @author asolopa
 */
@Service
@RequiredArgsConstructor
public class OtherTelegramUpdateServiceImpl implements OtherTelegramUpdateService {
    private final ReplyKeyboardMarkup replyKeyboardMarkup;
    private final CurrentWeatherService currentWeatherService;
    private final ObjectMapper objectMapper;
    private final HttpClient httpClient;

    @Override
    public SendMessage onRandomMessageReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText(createReplyMessage(update, sendMessage));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private String createReplyMessage(Update update, SendMessage sendMessage) {

        Location location = update.getMessage().getLocation();
        if (location != null) {
            sendMessage.enableMarkdownV2(true);
            String separator = System.lineSeparator();
            String replyMessage = "Спасибо, текущий прогноз:" + separator + "```" + separator;
            CurrentWeatherDTO currentcurrentWeather = currentWeatherService.getCurrentForecast(location.getLongitude(), location.getLatitude());
            replyMessage += "General: " + currentcurrentWeather.getSky() + separator;
            replyMessage += "Температура: " + currentcurrentWeather.getTemperature() + separator;
            replyMessage += "Температура ощущается как: " + currentcurrentWeather.getTemperatureFeelsLike() + separator;
            replyMessage += "Температура мин: " + currentcurrentWeather.getTemperatureMin() + separator;
            replyMessage += "Температура макс: " + currentcurrentWeather.getTemperatureMax() + separator;
            replyMessage += "Давление: " + currentcurrentWeather.getPressure() + separator;
            replyMessage += "Влажность: " + currentcurrentWeather.getHumidity() + separator;
            replyMessage += "Видимость: " + currentcurrentWeather.getVisibility() + separator;
            replyMessage += "Страна: " + currentcurrentWeather.getCountry() + separator;
            replyMessage += "Область: " + currentcurrentWeather.getCityName() + separator;
            return replyMessage + "```";
        } else {
            return "Поделитесь своими кординатами..✨";
        }
    }
}
