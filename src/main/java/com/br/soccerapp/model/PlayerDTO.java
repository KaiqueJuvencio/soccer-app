package com.br.soccerapp.model;

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
    @OneToOne
    @JoinColumn(name = "team_id")
    private TeamDTO team;

    public PlayerDTO() {
    }

    public PlayerDTO(String name, TeamDTO team) {
        this.name = name;
        this.team = team;
    }
}
