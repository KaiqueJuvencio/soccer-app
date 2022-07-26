package com.br.soccerapp.service;

import com.br.soccerapp.model.LeagueDTO;
import com.br.soccerapp.model.StatisticsDTO;
import com.br.soccerapp.model.TeamDTO;
import com.br.soccerapp.repository.LeagueRepository;
import com.br.soccerapp.repository.StatisticsRepository;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

//    public List<TeamDTO> list(){
//        return teamRepository.findAll();
//    }

    public StatisticsDTO create(Long leagueId, Long teamId){
        Optional<LeagueDTO> league = leagueRepository.findById(leagueId);
        Optional<TeamDTO> team = teamRepository.findById(teamId);

        if(league.isPresent() && team.isPresent()){
            StatisticsDTO statisticsDTO = new StatisticsDTO(league.get(), team.get());
            return statisticsRepository.save(statisticsDTO);
        }else {
            throw new RuntimeException();
        }
    }

//    public void update(String name, Long teamId){
//        Optional<TeamDTO> team = teamRepository.findById(teamId);
//        if(team.isPresent()){
//            team.get().setName(name);
//            teamRepository.save(team.get());
//        }else {
//            throw new RuntimeException();
//        }
//    }
//
//    public void delete(Long id){
//        teamRepository.deleteById(id);
//    }
}
