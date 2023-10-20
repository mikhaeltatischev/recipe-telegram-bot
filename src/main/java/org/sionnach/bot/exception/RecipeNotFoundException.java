package org.sionnach.bot.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecipeNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Recipe with id: %s not found";

    public RecipeNotFoundException(Long id) {
        super(String.format(MESSAGE, id));
        log.error(String.format(MESSAGE, id));
    }
}