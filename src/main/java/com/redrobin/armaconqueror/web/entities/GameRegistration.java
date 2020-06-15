package com.redrobin.armaconqueror.web.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "game_registrations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"character_id", "game_id"}))
@Data
public class GameRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Column(name = "registered_at")
    private Date registered_at;

    @OneToOne
    @JoinColumn(name = "rank_id")
    private Rank rank;
}
