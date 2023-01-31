package com.br.soccerapp.controller;

import com.br.soccerapp.service.PlayerService;
import com.br.soccerapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping()
    public ResponseEntity<Object> list(){
        return ResponseEntity.ok(playerService.list());
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestParam String playerName, @RequestParam Long teamId){
        playerService.create(playerName, teamId);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{name}/{playerId}/{teamId}")
    public ResponseEntity<Object> update(@PathVariable String name, @PathVariable Long playerId, @PathVariable Long teamId){
        playerService.update(name, playerId, teamId);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        playerService.delete(id);
        return ResponseEntity.ok("");
    }
}
