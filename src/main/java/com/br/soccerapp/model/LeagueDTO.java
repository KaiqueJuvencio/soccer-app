package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "LEAGUE")
@Data
public class LeagueDTO {

    @Id
    private String id;
    private String name;
    private LocalDateTime startDate;
}
