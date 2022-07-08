package com.br.soccerapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @GetMapping
    public String list(){
        return "Team";
    }
}
