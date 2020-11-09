package com.thevoodoohuman.telegrambot.component;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
/**
 * @author asolopa
 */
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomWeatherKeyboard {
    CustomTelegramKeyboard keyboard;
    KeyboardRow keyboardRow;

    public CustomWeatherKeyboard(CustomTelegramKeyboard keyboard) {
        keyboardRow = new KeyboardRow();
        keyboardRow.clear();
        keyboardRow.add("Погода");
        this.keyboard = keyboard;
    }

    public void addKeyboardToLayout() {
        keyboard.clearLayout();
        keyboard.getKeyboard().add(keyboardRow);
    }
}
