package org.sionnach.bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private String area;

    @Column
    private String ingredients;

    @Column
    private String measures;

    @Column
    private String instruction;

    @Column
    private String description;

    @Column
    private String youtube;

    @Column
    private Long counter;

}