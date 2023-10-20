package org.sionnach.bot.keyboard;

import lombok.Getter;

@Getter
public enum Links {

    BROWS("/brows");

    private String value;

    Links(String value) {
        this.value = value;
    }

}