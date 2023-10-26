package org.sionnach.bot.command;

import lombok.SneakyThrows;
import org.sionnach.bot.builder.SendMessageBuilder;
import org.sionnach.bot.handler.CommandHandler;
import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.BotState;
import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.User;
import org.springframework.stereotype.Component;

@Component
public class MealCommand implements Command {

    @Override
    public Class handler() {
        return CommandHandler.class;
    }

    @Override
    public Object getFindBy() {
        return "/meal";
    }

    @SneakyThrows
    @Override
    public Answer getAnswer(ClassifiedUpdate update, User user) {
        return new SendMessageBuilder().chatId(user.getChatId()).buildMeal(update);
    }

}