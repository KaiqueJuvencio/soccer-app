package com.br.soccerapp.controller;

import com.br.soccerapp.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/league")
public class LeagueController {

    @Autowired
    LeagueService leagueService;

    @PostMapping("/{name}")
    public ResponseEntity<Object> create(@PathVariable String name){
        leagueService.create(name);
        return ResponseEntity.ok("");
    }
}
