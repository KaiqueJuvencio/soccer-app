package com.br.soccerapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LEAGUE")
@Data
public class LeagueEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDateTime startDate;

    public LeagueEntity(String name) {
        this.name = name;
        this.startDate = LocalDateTime.now();
    }
    public LeagueEntity() {
    }
}
