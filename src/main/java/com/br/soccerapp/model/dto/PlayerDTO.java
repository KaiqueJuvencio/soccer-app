package com.br.soccerapp.model.dto;

import com.br.soccerapp.model.entity.Player;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PLAYER")
@Data
public class PlayerDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    private Long teamId;

    public PlayerDTO() {
    }

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.teamId = player.getTeam().getId();
    }
}
