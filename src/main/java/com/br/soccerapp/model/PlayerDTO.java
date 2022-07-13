package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PLAYER")
@Data
public class PlayerDTO {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    @OneToOne
    @JoinColumn(name = "team_id")
    private TeamDTO team;
}
