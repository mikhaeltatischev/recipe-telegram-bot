package org.sionnach.bot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true, nullable = false)
    private Long chatId;

    @Column(nullable = false)
    private Long permissions;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private State state;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String phone;

}