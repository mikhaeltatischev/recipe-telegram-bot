package org.sionnach.bot.callBack;

import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.User;

public interface CallBack {

    Class handler();

    Object getFindBy();

    Answer getAnswer(ClassifiedUpdate update, User user);

}