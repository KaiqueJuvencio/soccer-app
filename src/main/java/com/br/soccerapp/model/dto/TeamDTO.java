package com.br.soccerapp.model.dto;

import com.br.soccerapp.model.entity.League;
import lombok.Data;

@Data
public class TeamDTO {

    private Long id;
    private String name;

    private Long leagueId;

    public TeamDTO(Long id, String name, Long leagueId) {
        this.id = id;
        this.name = name;
        this.leagueId = leagueId;
    }

    public TeamDTO() {
    }
}
