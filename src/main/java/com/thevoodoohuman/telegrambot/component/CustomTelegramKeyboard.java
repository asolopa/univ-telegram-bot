package com.thevoodoohuman.telegrambot.component;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
/**
 * @author asolopa
 */
@Component
@Data
public class CustomTelegramKeyboard {
    ArrayList<KeyboardRow> keyboard = new ArrayList<>();

    public void clearLayout() {
        keyboard.clear();
    }
}
