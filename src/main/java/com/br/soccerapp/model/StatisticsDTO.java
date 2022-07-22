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
    private Integer goalDifference;
    private Integer points;
    private Integer matchesQuantities;
}
