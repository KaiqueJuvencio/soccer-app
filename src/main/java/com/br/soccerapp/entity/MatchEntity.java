package com.br.soccerapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MATCH")
@Data
public class MatchEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "team_home")
    private TeamEntity teamHome;
    @OneToOne
    @JoinColumn(name = "team_visitor")
    private TeamEntity teamVisitor;

    public MatchEntity() {
    }

    public MatchEntity(TeamEntity teamHome, TeamEntity teamVisitor) {
        this.teamHome = teamHome;
        this.teamVisitor = teamVisitor;
    }
}
