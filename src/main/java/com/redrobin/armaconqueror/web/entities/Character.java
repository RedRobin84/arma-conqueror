package com.redrobin.armaconqueror.web.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "characters")
@Data
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "character")
    private Set<GameRegistration> gameRegistrations;

    @Column(name = "hardcore")
    private boolean isHardcore;

    @Column(name = "loadout")
    private String loadout;
}
