package org.sionnach.bot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sionnach.bot.client.RecipeClient;
import org.sionnach.bot.handler.HandlersMap;
import org.sionnach.bot.model.*;
import org.sionnach.bot.service.UserService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateController {

    private final UserService userService;
    private final HandlersMap commandMap;
    private final RecipeClient recipeClient;
    private BotState botState;

    public Answer request(Update update) {
        ClassifiedUpdate classifiedUpdate = new ClassifiedUpdate(update);
        User user = userService.findUserByUpdate(classifiedUpdate);

        if (botState != null) {
            if (botState.equals(BotState.WAITING_NAME)) {
                setMealByName(classifiedUpdate);
            } else if (botState.equals(BotState.WAITING_INGREDIENT)) {
                setMealByIngredient(classifiedUpdate);
            } else if (botState.equals(BotState.DEFAULT)) {
                setMealById(classifiedUpdate);
            }
        }

        Answer answer = commandMap.execute(classifiedUpdate, user);
        checkBotState(classifiedUpdate);

        return answer;
    }

    private void checkBotState(ClassifiedUpdate update) {
        if (update.getBotState() != null) {
            botState = update.getBotState();
        }
    }

    private void setMealByName(ClassifiedUpdate update) {
        String name = update.getUpdate().getMessage().getText();
        List<Meal> meal = recipeClient.findByName(name);

        update.setTelegramType(TelegramType.Command);
        update.setCommandName("/meal");
        update.setMeals(meal);
    }

    private void setMealByIngredient(ClassifiedUpdate update) {
        String ingredient = update.getUpdate().getMessage().getText();
        List<Meal> meal = recipeClient.findByMainIngredient(ingredient);

        update.setTelegramType(TelegramType.Command);
        update.setCommandName("/meal");
        update.setMeals(meal);
    }

    private void setMealById(ClassifiedUpdate update) {
        String id = update.getArgs().get(0);
        List<Meal> meal = recipeClient.findById(id);

        update.setTelegramType(TelegramType.Command);
        update.setCommandName("/meal");
        update.setMeals(meal);
    }
}