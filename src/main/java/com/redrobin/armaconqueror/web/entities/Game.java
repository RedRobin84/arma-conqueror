package com.redrobin.armaconqueror.web.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "games")
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "finished_at")
    private Date finishedAt;

    @OneToMany(mappedBy = "game")
    private Set<GameRegistration> gameRegistrations;
}
