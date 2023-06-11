package com.br.soccerapp.service;

import com.br.soccerapp.exception.ObjectNullException;
import com.br.soccerapp.model.dto.StatisticsDTO;
import com.br.soccerapp.model.entity.Statistics;
import com.br.soccerapp.model.entity.Team;
import com.br.soccerapp.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    @Autowired
    StatisticsRepository statisticsRepository;

    @Autowired
    TeamService teamService;

    public List<StatisticsDTO> list(){
        return statisticsRepository.findAll()
                .stream()
                .map(Statistics::toDTO)
                .collect(Collectors.toList());
    }

    public Statistics findById(Long id){
        return statisticsRepository.findById(id).orElseThrow(()-> new ObjectNullException("Statistics not exist"));
    }

    public Statistics findByTeam(Team team){
        return statisticsRepository.findByTeam(team).orElseThrow(()-> new ObjectNullException("Statistics not found"));
    }

    public Statistics create(Long teamId){
        Team team = teamService.findById(teamId);
        Statistics statisticsDTO = new Statistics(team);
        return statisticsRepository.save(statisticsDTO);
    }

    public Statistics update(Long teamId, String matchResult){
        Team team = teamService.findById(teamId);
        Statistics statistic = this.findByTeam(team);
        statistic.setMatchesQuantities(statistic.getMatchesQuantities() + 1);
        switch (matchResult) {
            case "victory":
                statistic.setVictories(statistic.getVictories() + 1);
                statistic.setPoints(statistic.getPoints() + 3);
                break;
            case "defeat":
                statistic.setDefeats(statistic.getDefeats() + 1);
                break;
            case "draw":
                statistic.setDraws(statistic.getDraws() + 1);
                statistic.setPoints(statistic.getPoints() + 1);
                break;
        }
        return statisticsRepository.save(statistic);
    }

    public void delete(Long id){
        this.findById(id);
        statisticsRepository.deleteById(id);
    }
}
