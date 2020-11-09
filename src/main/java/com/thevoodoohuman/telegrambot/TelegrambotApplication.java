package com.thevoodoohuman.telegrambot;

import com.thevoodoohuman.telegrambot.component.TelegramBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TelegrambotApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TelegrambotApplication.class, args);
        TelegramBot telegramBot = (TelegramBot) context.getBean("telegramBot");
        System.out.println(telegramBot.getBotToken() + " " + telegramBot.getBotUsername());
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}