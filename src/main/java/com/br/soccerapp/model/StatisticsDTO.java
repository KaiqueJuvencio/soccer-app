package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATISTICS")
@Data
public class StatisticsDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @OneToOne
    private LeagueDTO league;
    @ManyToOne
    @OneToOne
    private TeamDTO team;
    private Integer victories;
    private Integer defeats;
    private Integer draws;
    private Integer goalDifference;
    private Integer points;
    private Integer matchesQuantities;

    public StatisticsDTO() {
    }

    public StatisticsDTO(LeagueDTO league, TeamDTO team) {
        this.league = league;
        this.team = team;
        this.defeats = 0;
        this.victories = 0;
        this.draws = 0;
        this.goalDifference = 0;
        this.points = 0;
        this.matchesQuantities = 0;
    }
}
