package com.br.soccerapp.controller;

import com.br.soccerapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping()
    public ResponseEntity<Object> list(){
        return ResponseEntity.ok(teamService.list());
    }

    @PostMapping("/{name}/{leagueId}")
    public ResponseEntity<Object> create(@PathVariable String name, @PathVariable Long leagueId){
        teamService.create(name, leagueId);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{name}/{teamId}")
    public ResponseEntity<Object> update(@PathVariable String name, @PathVariable Long teamId){
        teamService.update(name, teamId);
        return ResponseEntity.ok("");
    }
}
