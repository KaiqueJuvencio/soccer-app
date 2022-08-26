package com.br.soccerapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
@Data
public class TeamEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueEntity league;

    public TeamEntity(String name, LeagueEntity league) {
        this.name = name;
        this.league = league;
    }

    public TeamEntity() {
    }
}
