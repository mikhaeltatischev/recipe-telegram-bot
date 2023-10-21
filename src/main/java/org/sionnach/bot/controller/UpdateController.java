package org.sionnach.bot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sionnach.bot.client.RecipeClient;
import org.sionnach.bot.handler.HandlersMap;
import org.sionnach.bot.model.*;
import org.sionnach.bot.service.UserService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateController {

    private final UserService userService;
    private final HandlersMap commandMap;
    private final RecipeClient client;
    private BotState botState;

    public Answer request(Update update) {
        ClassifiedUpdate classifiedUpdate = new ClassifiedUpdate(update);
        User user = userService.findUserByUpdate(classifiedUpdate);

        if (botState != null) {
            if (botState.equals(BotState.WAITING_NAME)) {

            }
            if (botState.equals(BotState.WAITING_INGREDIENTS)) {

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
}