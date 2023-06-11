package com.br.soccerapp.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "GOALS")
@Data
public class Goals {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    @ManyToOne
    @JoinColumn(name = "goals_team_id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    private Integer quantities;

    public Goals() {
    }
}
