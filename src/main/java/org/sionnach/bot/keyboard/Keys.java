package org.sionnach.bot.keyboard;

import lombok.Getter;

@Getter
public enum Keys {

    MANICURE("Маникюр");

    private String value;

    Keys(String value) {
        this.value = value;
    }

}