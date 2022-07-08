package com.br.soccerapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
@Data
public class TeamDTO {

    @Id
    private String id;
    private String name;
}
