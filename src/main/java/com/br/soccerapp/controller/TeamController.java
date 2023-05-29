package com.br.soccerapp.controller;

import com.br.soccerapp.model.entity.Team;
import com.br.soccerapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping()
    public ResponseEntity<List<Team>> list(){
        return ResponseEntity.ok(teamService.list());
    }

    @PostMapping("/{name}/{leagueId}")
    public ResponseEntity<Void> create(@PathVariable String name, @PathVariable Long leagueId){
        teamService.create(name, leagueId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{name}/{teamId}")
    public ResponseEntity<Void> update(@PathVariable String name, @PathVariable Long teamId){
        teamService.update(name, teamId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        teamService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
