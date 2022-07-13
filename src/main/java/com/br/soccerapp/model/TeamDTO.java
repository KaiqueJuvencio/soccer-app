package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
@Data
public class TeamDTO {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueDTO league;
}
