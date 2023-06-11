package com.br.soccerapp.model.dto;

import com.br.soccerapp.model.entity.Team;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "STATISTICS")
@Data
public class StatisticsDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long teamId;
    private Integer victories;
    private Integer defeats;
    private Integer draws;
    private Integer goalDifference;
    private Integer points;
    private Integer matchesQuantities;


    public StatisticsDTO() {
    }

    public StatisticsDTO(Team team) {
        this.defeats = 0;
        this.victories = 0;
        this.draws = 0;
        this.goalDifference = 0;
        this.points = 0;
        this.matchesQuantities = 0;
    }
}
