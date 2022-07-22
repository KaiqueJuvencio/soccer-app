package com.br.soccerapp.service;

import com.br.soccerapp.model.LeagueDTO;
import com.br.soccerapp.model.TeamDTO;
import com.br.soccerapp.repository.LeagueRepository;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    LeagueRepository leagueRepository;

    public List<TeamDTO> list(){
        return teamRepository.findAll();
    }

    public TeamDTO create(String name, Long leagueId){
        Optional<LeagueDTO> league = leagueRepository.findById(leagueId);
        if(league.isPresent()){
            TeamDTO teamDTO = new TeamDTO(name, league.get());
            return teamRepository.save(teamDTO);
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
