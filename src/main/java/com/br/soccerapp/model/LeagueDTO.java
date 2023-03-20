package com.br.soccerapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDateTime startDate;

    public LeagueDTO(String name) {
        this.name = name;
        this.startDate = LocalDateTime.now();
    }
    public LeagueDTO() {
    }
}
