package org.sionnach.bot.callBack;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.sionnach.bot.builder.SendMessageBuilder;
import org.sionnach.bot.handler.CallBackHandler;
import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.Recipe;
import org.sionnach.bot.model.User;
import org.sionnach.bot.service.RecipeService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PopularCallBack implements CallBack {

    private final RecipeService service;

    @Override
    public Class handler() {
        return CallBackHandler.class;
    }

    @Override
    public Object getFindBy() {
        return "/popular";
    }

    @SneakyThrows
    @Override
    public Answer getAnswer(ClassifiedUpdate update, User user) {
        List<Recipe> recipes = service.getPopular();
        return new SendMessageBuilder().chatId(user.getChatId()).buildPopular(recipes);
    }

}