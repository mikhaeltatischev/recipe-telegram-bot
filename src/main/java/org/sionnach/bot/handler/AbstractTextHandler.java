package org.sionnach.bot.handler;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.MappedSuperclass;
import org.sionnach.bot.text.Text;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractTextHandler implements Handler {

    protected final Map<Object, Text> allText = new HashMap<>();

    @Autowired
    private List<Text> commands;

    protected abstract HashMap<Object, Text> createMap();

    @PostConstruct
    private void init() {
        commands.forEach(c -> {
            allText.put(c.getFindBy(), c);
            if(Objects.equals(c.handler().getName(), this.getClass().getName())) {
                createMap().put(c.getFindBy(), c);

                System.out.println(c.getClass().getSimpleName() + " was added for " + this.getClass().getSimpleName());
            }
        });
    }

}