package org.sionnach.bot.text;

import lombok.SneakyThrows;
import org.sionnach.bot.builder.SendMessageBuilder;
import org.sionnach.bot.handler.TextHandler;
import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.User;
import org.springframework.stereotype.Component;

@Component
public class CreateProfileText implements Text {

    @Override
    public Class handler() {
        return TextHandler.class;
    }

    @Override
    public Object getFindBy() {
        return TextValues.EDIT_PROFILE.getValue();
    }

    @SneakyThrows
    @Override
    public Answer getAnswer(ClassifiedUpdate update, User user) {
        return new SendMessageBuilder().chatId(user.getChatId()).buildStart();
    }

}
