package com.br.soccerapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "GOALS")
@Data
public class GoalsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchEntity match;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;
    private Integer quantities;

    public GoalsEntity() {
    }
}
