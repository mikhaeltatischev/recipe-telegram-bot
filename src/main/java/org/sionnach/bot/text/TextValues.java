package org.sionnach.bot.text;

import lombok.Getter;

@Getter
public enum TextValues {

    APPOINTMENT("Записаться");

    private final String value;

    TextValues(String value) {
        this.value = value;
    }

}