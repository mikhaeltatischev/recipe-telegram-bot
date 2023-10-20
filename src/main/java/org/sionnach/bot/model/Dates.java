package org.sionnach.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dates {

    @JsonProperty("dates_true")
    private List<String> datesTrue;

}