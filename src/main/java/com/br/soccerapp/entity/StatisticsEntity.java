package com.br.soccerapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "STATISTICS")
@Data
public class StatisticsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @OneToOne
    private TeamEntity team;
    private Integer victories;
    private Integer defeats;
    private Integer draws;
    private Integer goalDifference;
    private Integer points;
    private Integer matchesQuantities;

    public StatisticsEntity() {
    }

    public StatisticsEntity(TeamEntity team) {
        this.team = team;
        this.defeats = 0;
        this.victories = 0;
        this.draws = 0;
        this.goalDifference = 0;
        this.points = 0;
        this.matchesQuantities = 0;
    }
}
