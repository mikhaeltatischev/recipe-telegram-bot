package org.sionnach.bot.keyboard;

import lombok.Getter;

@Getter
public enum Keys {

    MANICURE("Маникюр"),
    PEDICURE("Педикюр"),
    BROWS("Брови"),
    LASHES("Ресницы"),
    COMB_MANICURE("Комбинированный маникюр"),
    DESIGN_MANICURE("Маникюр с дизайном"),
    STRENGTH_MANICURE("Маникюр с укреплением"),
    EXTENSION_MANICURE("Наращивание"),
    PLAIN_MANICURE("Однотонное покрытие");

    private String value;

    Keys(String value) {
        this.value = value;
    }

}