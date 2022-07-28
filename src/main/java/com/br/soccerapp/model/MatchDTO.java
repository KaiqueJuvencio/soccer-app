package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MATCH")
@Data
public class MatchDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "team_home")
    private TeamDTO teamHome;
    @OneToOne
    @JoinColumn(name = "team_visitor")
    private TeamDTO teamVisitor;

    public MatchDTO() {
    }

    public MatchDTO(TeamDTO teamHome, TeamDTO teamVisitor) {
        this.teamHome = teamHome;
        this.teamVisitor = teamVisitor;
    }
}
