package org.sionnach.bot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public Answer request(Update update) {
        ClassifiedUpdate classifiedUpdate = new ClassifiedUpdate(update);
        User user = userService.findUserByUpdate(classifiedUpdate);

        return commandMap.execute(classifiedUpdate, user);
    }
}