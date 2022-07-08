package com.br.soccerapp.controller;

import com.br.soccerapp.model.TeamDTO;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping
    public String list(){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setName("SPFC");
        teamDTO.setId("1");
        teamRepository.save(teamDTO);
        return "Team";
    }
}
