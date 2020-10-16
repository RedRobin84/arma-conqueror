package com.redrobin.armaconqueror.web.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "equipments")
@Data
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
}
