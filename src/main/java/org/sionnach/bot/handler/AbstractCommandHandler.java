package org.sionnach.bot.handler;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.MappedSuperclass;
import org.sionnach.bot.command.Command;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractCommandHandler implements Handler {

    protected final Map<Object, Command> allCommands = new HashMap<>();

    @Autowired
    private List<Command> commands;

    protected abstract HashMap<Object, Command> createMap();

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