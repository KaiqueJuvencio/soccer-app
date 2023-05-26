package com.br.soccerapp.model.dto;

import com.br.soccerapp.model.entity.League;
import lombok.Data;

@Data
public class TeamDTO {

    private Long id;
    private String name;

    private Long leagueId;

    public TeamDTO(String name, Long leagueId) {
        this.name = name;
        this.leagueId = leagueId;
    }

    public TeamDTO() {
    }
}
