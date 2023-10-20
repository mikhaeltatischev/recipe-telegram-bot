package org.sionnach.bot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "masters")
@Getter
@Setter
public class Master {

    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String russianName;
}