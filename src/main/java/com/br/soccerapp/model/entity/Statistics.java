package com.br.soccerapp.model.entity;

import com.br.soccerapp.model.dto.StatisticsDTO;
import com.br.soccerapp.model.dto.TeamDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "STATISTICS")
@Data
public class Statistics {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "statistics_team_id")
    private Team team;
    private Integer victories;
    private Integer defeats;
    private Integer draws;
    private Integer goalDifference;
    private Integer points;
    private Integer matchesQuantities;

    public Statistics() {
    }

    public Statistics(Team team) {
        this.team = team;
        this.defeats = 0;
        this.victories = 0;
        this.draws = 0;
        this.goalDifference = 0;
        this.points = 0;
        this.matchesQuantities = 0;
    }

    public static StatisticsDTO toDTO(Statistics statistics){
        StatisticsDTO statisticsDTO = new StatisticsDTO();
        statisticsDTO.setTeamId(statistics.getTeam().getId());
        statisticsDTO.setId(statistics.getId());
        statisticsDTO.setVictories(statistics.getVictories());
        statisticsDTO.setDefeats(statistics.getDefeats());
        statisticsDTO.setDraws(statistics.getDraws());
        statisticsDTO.setGoalDifference(statistics.getGoalDifference());
        statisticsDTO.setPoints(statistics.getPoints());
        statisticsDTO.setMatchesQuantities(statistics.getMatchesQuantities());
        return statisticsDTO;
    }
}
