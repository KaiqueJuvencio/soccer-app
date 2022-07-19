package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LEAGUE")
@Data
public class LeagueDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDateTime startDate;

    public LeagueDTO(String name) {
        this.name = name;
        this.startDate = LocalDateTime.now();
    }
}
