package org.sionnach.bot.handler;

import org.sionnach.bot.command.Command;
import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.TelegramType;
import org.sionnach.bot.model.User;
import org.sionnach.bot.text.Text;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TextHandler extends AbstractTextHandler {

    private HashMap<Object, Text> hashMap = new HashMap<>();

    @Override
    protected HashMap<Object, Text> createMap() {
        return hashMap;
    }

    @Override
    public TelegramType getHandleType() {
        return TelegramType.Text;
    }

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public boolean condition(User user, ClassifiedUpdate update) {
        return hashMap.containsKey(update.getCommandName());
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        return hashMap.get(update.getCommandName()).getAnswer(update, user);
    }

}