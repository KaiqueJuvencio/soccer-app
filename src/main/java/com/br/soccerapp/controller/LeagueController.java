package com.br.soccerapp.controller;

import com.br.soccerapp.model.entity.League;
import com.br.soccerapp.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/league")
public class LeagueController {

    @Autowired
    LeagueService leagueService;

    @GetMapping()
    public ResponseEntity<List<League>> list(){
        return ResponseEntity.ok(leagueService.list());
    }

    @PostMapping("/{name}")
    public ResponseEntity<Void> create(@PathVariable String name){
        leagueService.create(name);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody League league){
        leagueService.update(league);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        leagueService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
