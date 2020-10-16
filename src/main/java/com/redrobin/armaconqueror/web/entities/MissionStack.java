package com.redrobin.armaconqueror.web.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mission_stack")
@Data
public class MissionStack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    private Mission currentMission;

    @OneToMany
    private List<Mission> followingMissions;
}
