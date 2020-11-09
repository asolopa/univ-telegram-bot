package com.thevoodoohuman.telegrambot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface StartTelegramUpdateService {
    SendMessage onStartTelegramUpdateMessage(Update update);
}
