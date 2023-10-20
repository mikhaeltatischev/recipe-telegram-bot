package org.sionnach.bot.keyboard;

import lombok.Getter;

@Getter
public enum Links {

    BROWS("/brows"),
    MANICURE("/manicure"),
    PEDICURE("/pedicure"),
    LASHES("/lashes"),
    MANICURIST("/manicurist"),
    COMB_MANICURE("/manicure/combmanicure"),
    DESIGN_MANICURE("/manicure/design"),
    STRENGTH_MANICURE("/manicure/strength"),
    EXTENSION_MANICURE("/manicure/extension"),
    PLAIN_MANICURE("/manicure/plain");

    private String value;

    Links(String value) {
        this.value = value;
    }

}