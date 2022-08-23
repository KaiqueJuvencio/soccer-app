package com.br.soccerapp.controller;

import com.br.soccerapp.model.LeagueDTO;
import com.br.soccerapp.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;

@RestController
@RequestMapping("/league")
public class LeagueController {

    @Autowired
    LeagueService leagueService;

    @GetMapping()
    public ResponseEntity<Object> list(){
        return ResponseEntity.ok(leagueService.list());
    }

    @PostMapping("/{name}")
    public ResponseEntity<Object> create(@PathVariable String name){
        leagueService.create(name);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}/{name}")
    public ResponseEntity<Object> update(@PathVariable Long id, @PathVariable String name){
        leagueService.update(id, name);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        leagueService.delete(id);
        return ResponseEntity.ok("");
    }
}
