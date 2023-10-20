package org.sionnach.bot.text;

import lombok.Getter;

@Getter
public enum TextValues {

    APPOINTMENT("Записаться"),
    EDIT_PROFILE("Редактировать профиль"),
    CREATE_PROFILE("Создать профиль");

    private final String value;

    TextValues(String value) {
        this.value = value;
    }

}