package org.sionnach.bot.handler;

import org.sionnach.bot.model.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface Handler {

    TelegramType getHandleType();

    int priority();

    boolean condition(User user, ClassifiedUpdate update);

    Answer getAnswer(User user, ClassifiedUpdate update);

}