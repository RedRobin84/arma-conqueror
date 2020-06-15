package com.redrobin.armaconqueror.web.entities;

import com.redrobin.armaconqueror.web.enums.RankType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ranks")
@Data
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rank_type")
    private RankType rankType;

    @Column
    private int xp;

    @OneToOne(mappedBy = "rank")
    private GameRegistration gameRegistration;
}
