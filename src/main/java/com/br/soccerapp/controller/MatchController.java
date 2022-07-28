package com.br.soccerapp.controller;

import com.br.soccerapp.service.MatchService;
import com.br.soccerapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @Autowired
    TeamService teamService;

    @GetMapping()
    public ResponseEntity<Object> list(){
        return ResponseEntity.ok(teamService.list());
    }

    @PostMapping("/{homeTeamId}/{awayTeamId}")
    public ResponseEntity<Object> create(@PathVariable Long homeTeamId, @PathVariable Long awayTeamId){
        matchService.create(homeTeamId, awayTeamId);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{name}/{teamId}")
    public ResponseEntity<Object> update(@PathVariable String name, @PathVariable Long teamId){
        teamService.update(name, teamId);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        teamService.delete(id);
        return ResponseEntity.ok("");
    }
}
