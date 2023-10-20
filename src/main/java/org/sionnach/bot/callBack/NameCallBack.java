package org.sionnach.bot.callBack;

import lombok.SneakyThrows;
import org.sionnach.bot.builder.SendMessageBuilder;
import org.sionnach.bot.handler.CallBackHandler;
import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.User;
import org.springframework.stereotype.Component;

@Component
public class NameCallBack implements CallBack {

    @Override
    public Class handler() {
        return CallBackHandler.class;
    }

    @Override
    public Object getFindBy() {
        return "/name";
    }

    @SneakyThrows
    @Override
    public Answer getAnswer(ClassifiedUpdate update, User user) {
        return new SendMessageBuilder().chatId(user.getChatId()).buildName();
    }

}