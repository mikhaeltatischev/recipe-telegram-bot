package org.sionnach.bot.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Times {

    @JsonProperty("1884624")
    @JsonAlias("2325318")
    private List<String> master;

}