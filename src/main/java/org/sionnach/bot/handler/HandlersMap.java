package org.sionnach.bot.handler;

import jakarta.annotation.PostConstruct;
import org.sionnach.bot.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class HandlersMap {

    private final List<Handler> handlers;
    private HashMap<TelegramType, List<Handler>> hashMap = new HashMap<>();
    private BotState botState;

    public HandlersMap(List<Handler> handlers) {
        this.handlers = handlers;
        this.botState = BotState.DEFAULT;
    }

    @PostConstruct
    private void init() {
        for(Handler handler : handlers) {
            if(!hashMap.containsKey(handler.getHandleType()))
                hashMap.put(handler.getHandleType(), new ArrayList<>());

            hashMap.get(handler.getHandleType()).add(handler);
        }

        hashMap.values().forEach(h -> h.sort((o1, o2) -> o2.priority() - o1.priority()));
    }

    public Answer execute(ClassifiedUpdate classifiedUpdate, User user) {
        if (!hashMap.containsKey(classifiedUpdate.getTelegramType())) {
            return new Answer();
        }

        for (Handler handler : hashMap.get(classifiedUpdate.getTelegramType())) {
            if (handler.condition(user, classifiedUpdate)) {
                return handler.getAnswer(user, classifiedUpdate);
            }
        }
        return null;
    }
}