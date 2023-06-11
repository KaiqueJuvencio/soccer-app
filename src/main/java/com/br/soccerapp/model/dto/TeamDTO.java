package com.br.soccerapp.model.dto;

import com.br.soccerapp.model.entity.League;
import com.br.soccerapp.model.entity.Team;
import lombok.Data;

@Data
public class TeamDTO {

    private Long id;
    private String name;

    private Long leagueId;

    public TeamDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.leagueId = team.getLeagueId();
    }

    public TeamDTO() {
    }
}
