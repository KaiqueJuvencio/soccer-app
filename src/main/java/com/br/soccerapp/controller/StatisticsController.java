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

    @PostMapping("/{teamId}")
    public ResponseEntity<Object> create(@PathVariable Long teamId){
        statisticsService.create(teamId);
        return ResponseEntity.ok("");
    }

    @PutMapping("/{teamId}/{statistic}")
    public ResponseEntity<Object> update(@PathVariable Long teamId, @PathVariable String statistic){
        return ResponseEntity.ok(statisticsService.update(teamId, statistic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        statisticsService.delete(id);
        return ResponseEntity.ok("");
    }
}
