package org.sionnach.bot.handler;

import jakarta.persistence.MappedSuperclass;
import org.sionnach.bot.model.*;

@MappedSuperclass
public interface Handler {

    TelegramType getHandleType();

    int priority();

    boolean condition(User user, ClassifiedUpdate update);

    Answer getAnswer(User user, ClassifiedUpdate update);

}