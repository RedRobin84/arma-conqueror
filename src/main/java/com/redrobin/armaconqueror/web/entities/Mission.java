package com.redrobin.armaconqueror.web.entities;

import com.redrobin.armaconqueror.web.enums.MissionType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "missions")
@Data
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private MissionType missionType;

    @Column(name = "start_area")
    private String startArea;
}
