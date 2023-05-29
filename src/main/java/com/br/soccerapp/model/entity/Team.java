package com.br.soccerapp.model.entity;

import com.br.soccerapp.model.dto.TeamDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @Column(name = "league_id", insertable = false, updatable = false)
    private Long leagueId;

    public Team(String name, League league) {
        this.name = name;
        this.league = league;
    }

    public Team() {
    }

    public static TeamDTO toDTO(Team team){
        return new TeamDTO(team.getId(), team.getName(), team.getLeagueId());
    }
}
