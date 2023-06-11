package com.br.soccerapp.model.entity;

import com.br.soccerapp.model.dto.PlayerDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PLAYER")
@Data
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "player_team_id")
    private Team team;

    public Player() {
    }

    public Player(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public static PlayerDTO toDTO(Player player){
        return new PlayerDTO(player);
    }
}
