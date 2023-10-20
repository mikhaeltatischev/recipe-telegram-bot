package org.sionnach.bot.handler;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.MappedSuperclass;
import org.sionnach.bot.callBack.CallBack;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractCallBackHandler implements Handler {

    protected final Map<Object, CallBack> allCommands = new HashMap<>();

    @Autowired
    private List<CallBack> commands;

    protected abstract HashMap<Object, CallBack> createMap();

    @PostConstruct
    private void init() {
        commands.forEach(c -> {
            allCommands.put(c.getFindBy(), c);
            if(Objects.equals(c.handler().getName(), this.getClass().getName())) {
                createMap().put(c.getFindBy(), c);

                System.out.println(c.getClass().getSimpleName() + " was added for " + this.getClass().getSimpleName());
            }
        });
    }

}