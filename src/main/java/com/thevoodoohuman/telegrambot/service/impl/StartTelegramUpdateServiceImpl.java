package com.thevoodoohuman.telegrambot.service.impl;

import com.thevoodoohuman.telegrambot.component.CustomWeatherKeyboard;
import com.thevoodoohuman.telegrambot.service.StartTelegramUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

/**
 * @author asolopa
 */
@Service
@RequiredArgsConstructor
public class StartTelegramUpdateServiceImpl implements StartTelegramUpdateService {
    private final ReplyKeyboardMarkup replyKeyboardMarkup;
    private final CustomWeatherKeyboard weatherKeyboard;

    @Override
    public SendMessage onStartTelegramUpdateMessage(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText("Доступный функционал: Погода");
        weatherKeyboard.addKeyboardToLayout();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
}
