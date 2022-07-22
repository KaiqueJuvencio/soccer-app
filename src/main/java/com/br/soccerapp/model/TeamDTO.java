package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
@Data
public class TeamDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueDTO league;

    public TeamDTO(String name, LeagueDTO league) {
        this.name = name;
        this.league = league;
    }
}
