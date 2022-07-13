package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "GOALS")
@Data
public class GoalsDTO {

    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchDTO match;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamDTO team;
    private String author;
    private Integer quantities;
}
