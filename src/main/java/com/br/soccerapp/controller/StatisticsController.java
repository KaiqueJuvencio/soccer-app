package com.br.soccerapp.controller;

import com.br.soccerapp.model.entity.Statistics;
import com.br.soccerapp.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping()
    public ResponseEntity<List<Statistics>> list(){
        return ResponseEntity.ok(statisticsService.list());
    }

    @PostMapping("/{teamId}")
    public ResponseEntity<Void> create(@PathVariable Long teamId){
        statisticsService.create(teamId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{teamId}/{statistic}")
    public ResponseEntity<Statistics> update(@PathVariable Long teamId, @PathVariable String statistic){
        return ResponseEntity.ok(statisticsService.update(teamId, statistic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        statisticsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
