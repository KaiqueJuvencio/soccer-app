package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "GOALS")
@Data
public class GoalsDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchDTO match;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamDTO team;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerDTO player;
    private Integer quantities;

    public GoalsDTO() {
    }
}
