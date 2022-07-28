package com.br.soccerapp.service;

import com.br.soccerapp.model.LeagueDTO;
import com.br.soccerapp.model.MatchDTO;
import com.br.soccerapp.model.TeamDTO;
import com.br.soccerapp.repository.LeagueRepository;
import com.br.soccerapp.repository.MatchRepository;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepository matchRepository;

    public List<TeamDTO> list(){
        return teamRepository.findAll();
    }

    public MatchDTO create(Long homeTeamId, Long awayTeamId){
        Optional<TeamDTO> homeTeam = teamRepository.findById(homeTeamId);
        Optional<TeamDTO> awayTeam = teamRepository.findById(awayTeamId);
        if(homeTeam.isPresent() && awayTeam.isPresent()){
            MatchDTO matchDTO = new MatchDTO(homeTeam.get(), awayTeam.get());
            return matchRepository.save(matchDTO);
        }else {
            throw new RuntimeException();
        }
    }

    public void update(String name, Long teamId){
        Optional<TeamDTO> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            team.get().setName(name);
            teamRepository.save(team.get());
        }else {
            throw new RuntimeException();
        }
    }

    public void delete(Long id){
        teamRepository.deleteById(id);
    }
}
