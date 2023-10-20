package org.sionnach.bot.keyboard;

import lombok.Getter;

@Getter
public enum MasterName {

    DARIYA("/dariya"),
    ANNA("/anna");

    private String value;

    MasterName(String value) {
        this.value = value;
    }
}