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
        return ResponseEntity.ok(matchService.list());
    }

    @PostMapping("/{homeTeamId}/{awayTeamId}")
    public ResponseEntity<Object> create(@PathVariable Long homeTeamId, @PathVariable Long awayTeamId){
        matchService.create(homeTeamId, awayTeamId);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{matchId}/{homeTeamId}/{awayTeamId}")
    public ResponseEntity<Object> update(@PathVariable Long matchId, @PathVariable Long homeTeamId, @PathVariable Long awayTeamId){
        matchService.update(matchId, homeTeamId, awayTeamId);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        matchService.delete(id);
        return ResponseEntity.ok("");
    }
}
