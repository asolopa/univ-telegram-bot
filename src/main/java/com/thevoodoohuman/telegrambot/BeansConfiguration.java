package com.thevoodoohuman.telegrambot;

import com.thevoodoohuman.telegrambot.component.CustomTelegramKeyboard;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.net.http.HttpClient;

/**
 * @author asolopa
 */
@Configuration
@RequiredArgsConstructor
@EnableEncryptableProperties
public class BeansConfiguration {
    private final CustomTelegramKeyboard customTelegramKeyboard;


    @Bean
    public ReplyKeyboardMarkup replyKeyboardMarkup() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setKeyboard(customTelegramKeyboard.getKeyboard());
        return replyKeyboardMarkup;
    }

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newBuilder().build();
    }
}
