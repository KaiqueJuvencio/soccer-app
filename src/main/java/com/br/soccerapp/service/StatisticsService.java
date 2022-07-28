package com.br.soccerapp.service;

import com.br.soccerapp.model.StatisticsDTO;
import com.br.soccerapp.model.TeamDTO;
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

    public List<StatisticsDTO> list(){
        return statisticsRepository.findAll();
    }

    public StatisticsDTO create(Long teamId){
        Optional<TeamDTO> team = teamRepository.findById(teamId);

        if(team.isPresent()){
            StatisticsDTO statisticsDTO = new StatisticsDTO(team.get());
            return statisticsRepository.save(statisticsDTO);
        }else {
            throw new RuntimeException();
        }
    }

    public StatisticsDTO update(Long teamId, String statisticEnum){
        Optional<TeamDTO> team = teamRepository.findById(teamId);
        Optional<StatisticsDTO> statistic = statisticsRepository.findByTeam(team.get());
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
