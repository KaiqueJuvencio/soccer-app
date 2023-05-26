package com.br.soccerapp.service;

import com.br.soccerapp.exception.BadRequestException;
import com.br.soccerapp.exception.ObjectNullException;
import com.br.soccerapp.model.entity.Statistics;
import com.br.soccerapp.model.entity.Team;
import com.br.soccerapp.repository.LeagueRepository;
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
    LeagueRepository leagueRepository;

    @Autowired
    TeamRepository teamRepository;

    public List<Statistics> list(){
        return statisticsRepository.findAll();
    }

    public Statistics create(Long teamId){
        try{
            Optional<Team> team = teamRepository.findById(teamId);
            this.verifyIsNull(team);
            Statistics statisticsDTO = new Statistics(team.get());
            return statisticsRepository.save(statisticsDTO);
        }catch (ObjectNullException e){
            throw new ObjectNullException("Team not exist");
        }catch (Exception e){
            throw new BadRequestException("Error to create Statistic");
        }
    }

    public Statistics update(Long teamId, String statisticEnum){
        try {
            Optional<Team> team = teamRepository.findById(teamId);
            this.verifyIsNull(team);
            Optional<Statistics> statistic = statisticsRepository.findByTeam(team.get());
            this.verifyIsNull(statistic);
            statistic.get().setMatchesQuantities(statistic.get().getMatchesQuantities() + 1);
            switch (statisticEnum) {
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
        }catch (ObjectNullException e){
            throw new ObjectNullException("Team or Statistic not exist");
        }catch (Exception e) {
            throw new BadRequestException("Error to update Statistic");
        }
    }

    public void delete(Long id){
        try{
            Optional<Statistics> statistic = statisticsRepository.findById(id);
            this.verifyIsNull(statistic);
            statisticsRepository.deleteById(id);
        }catch (ObjectNullException e){
            throw new ObjectNullException("Statistic not exist");
        }catch (Exception e) {
            throw new BadRequestException("Error to delete Statistic");
        }
    }

    public void verifyIsNull(Optional<?> method){
        if(method.isEmpty()) throw new ObjectNullException("");
    }
}
