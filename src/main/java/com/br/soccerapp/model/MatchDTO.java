package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MATCH")
@Data
public class MatchDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueDTO league;
    @OneToOne
    @JoinColumn(name = "team_home")
    private TeamDTO teamHome;
    @OneToOne
    @JoinColumn(name = "team_visitor")
    private TeamDTO teamVisitor;

    public MatchDTO() {
    }
}
