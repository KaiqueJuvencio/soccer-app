package com.br.soccerapp.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MATCH")
@Data
public class Match {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;
    @OneToOne
    @JoinColumn(name = "team_home")
    private Team teamHome;
    @OneToOne
    @JoinColumn(name = "team_visitor")
    private Team teamVisitor;

    public Match() {
    }
}
