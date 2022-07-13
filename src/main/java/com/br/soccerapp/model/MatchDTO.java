package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MATCH")
@Data
public class MatchDTO {

    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueDTO league;
    @ManyToOne
    @JoinColumn(name = "team_home")
    private TeamDTO teamHome;
    @ManyToOne
    @JoinColumn(name = "team_visitor")
    private TeamDTO teamVisitor;
    @OneToMany
    @JoinColumn(name = "goals_id")
    private Integer goals;
}
