package com.br.soccerapp.service;

import com.br.soccerapp.entity.StatisticsEntity;
import com.br.soccerapp.entity.TeamEntity;
import com.br.soccerapp.repository.StatisticsRepository;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticsService {

    @Autowired
    StatisticsRepository statisticsRepository;

    @Autowired
    TeamRepository teamRepository;

    public List<StatisticsEntity> list(){
        return statisticsRepository.findAll();
    }

    public StatisticsEntity create(Long teamId){
        Optional<TeamEntity> team = teamRepository.findById(teamId);

        if(team.isPresent()){
            StatisticsEntity statisticsDTO = new StatisticsEntity(team.get());
            return statisticsRepository.save(statisticsDTO);
        }else {
            throw new RuntimeException();
        }
    }

    public StatisticsEntity update(Long teamId, String statisticEnum){
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        Optional<StatisticsEntity> statistic = statisticsRepository.findByTeam(team.get());
        if(statistic.isPresent() && team.isPresent()){
            statistic.get().setMatchesQuantities(statistic.get().getMatchesQuantities() + 1);
            switch (statisticEnum){
                case "victory":
                    statistic.get().setVictories(statistic.get().getVictories() + 1);
                    statistic.get().setPoints(statistic.get().getPoints() + 3);
                    break;
                case "defeat":
                    statistic.get().setDefeats(statistic.get().getDefeats() + 1);
                    break;
                case "draw":
                    statistic.get().setDraws(statistic.get().getDraws() + 1);
                    statistic.get().setPoints(statistic.get().getPoints() + 1);
                    break;
            }
            return statisticsRepository.save(statistic.get());
        }else {
            throw new RuntimeException();
        }
    }

    public void delete(Long id){
        statisticsRepository.deleteById(id);
    }
}
