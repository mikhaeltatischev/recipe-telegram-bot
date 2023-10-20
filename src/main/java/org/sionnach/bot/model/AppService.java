package org.sionnach.bot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "services")
@Getter
@Setter
public class AppService {

    @Id
    private Long id;

    @JoinColumn(name = "master_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Master master;

    @Column(nullable = false)
    private String name;
}