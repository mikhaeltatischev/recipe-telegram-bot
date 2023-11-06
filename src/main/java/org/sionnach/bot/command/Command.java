package org.sionnach.bot.command;

import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.User;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface Command {

    Class handler();

    Object getFindBy();

    Answer getAnswer(ClassifiedUpdate update, User user);

}
