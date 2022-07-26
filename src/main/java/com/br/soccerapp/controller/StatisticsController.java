package com.br.soccerapp.controller;

import com.br.soccerapp.model.StatisticsDTO;
import com.br.soccerapp.service.StatisticsService;
import com.br.soccerapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping()
    public ResponseEntity<Object> list(){
        return ResponseEntity.ok(statisticsService.list());
    }

    @PostMapping("/{leagueId}/{teamId}")
    public ResponseEntity<Object> create(@PathVariable Long leagueId, @PathVariable Long teamId){
        statisticsService.create(leagueId, teamId);
        return ResponseEntity.ok("");
    }

//    @PutMapping("/{name}/{teamId}")
//    public ResponseEntity<Object> update(@PathVariable String name, @PathVariable Long teamId){
//        teamService.update(name, teamId);
//        return ResponseEntity.ok("");
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> delete(@PathVariable Long id){
//        teamService.delete(id);
//        return ResponseEntity.ok("");
//    }
}
