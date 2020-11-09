package com.thevoodoohuman.telegrambot.component;

/**
 * @author a.solopa
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thevoodoohuman.telegrambot.service.OtherTelegramUpdateService;
import com.thevoodoohuman.telegrambot.service.StartTelegramUpdateService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author asolopa
 */
@Getter
@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final StartTelegramUpdateService startTelegramUpdateService;
    private final OtherTelegramUpdateService otherTelegramUpdateService;
    private final ObjectMapper objectMapper;
    @Value("${telegram.bot.username}")
    private String botUsername;
    @Value("${telegram.bot.token}")
    private String botToken;

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        String receivedMessage = update.getMessage().getText();
        System.out.println(objectMapper.writeValueAsString(update));

        SendMessage sendReplyMessage;
        if (receivedMessage != null && receivedMessage.contains("start")) {
            sendReplyMessage = startTelegramUpdateService.onStartTelegramUpdateMessage(update);
        } else {
            sendReplyMessage = otherTelegramUpdateService.onRandomMessageReceived(update);
        }

        super.execute(sendReplyMessage);

    }
}