package com.br.soccerapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PLAYER")
@Data
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    public PlayerEntity() {
    }

    public PlayerEntity(String name, TeamEntity team) {
        this.name = name;
        this.team = team;
    }
}
