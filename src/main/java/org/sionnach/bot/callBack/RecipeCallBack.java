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

@Component
@RequiredArgsConstructor
public class RecipeCallBack implements CallBack {

    private final RecipeService service;

    @Override
    public Class handler() {
        return CallBackHandler.class;
    }

    @Override
    public Object getFindBy() {
        return "/recipe";
    }

    @SneakyThrows
    @Override
    public Answer getAnswer(ClassifiedUpdate update, User user) {
        Recipe recipe = service.findRecipeById(Long.valueOf(update.getArgs().get(0)));
        return new SendMessageBuilder().chatId(user.getChatId()).buildRecipe(recipe);
    }

}