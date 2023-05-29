package com.br.soccerapp.controller;

import com.br.soccerapp.model.entity.Player;
import com.br.soccerapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping()
    public ResponseEntity<List<Player>> list(){
        return ResponseEntity.ok(playerService.list());
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestParam String playerName, @RequestParam Long teamId){
        playerService.create(playerName, teamId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{name}/{playerId}/{teamId}")
    public ResponseEntity<Void> update(@PathVariable String name, @PathVariable Long playerId, @PathVariable Long teamId){
        playerService.update(name, playerId, teamId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
