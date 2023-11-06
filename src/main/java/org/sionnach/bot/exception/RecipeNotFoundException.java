package org.sionnach.bot.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecipeNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Recipe not found";

    public RecipeNotFoundException() {
        super(MESSAGE);
        log.debug(MESSAGE);
    }

}