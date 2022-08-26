package com.br.soccerapp.service;

import com.br.soccerapp.entity.LeagueEntity;
import com.br.soccerapp.entity.TeamEntity;
import com.br.soccerapp.repository.LeagueRepository;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    LeagueRepository leagueRepository;

    public List<TeamEntity> list(){
        return teamRepository.findAll();
    }

    public TeamEntity create(String name, Long leagueId){
        Optional<LeagueEntity> league = leagueRepository.findById(leagueId);
        if(league.isPresent()){
            TeamEntity teamDTO = new TeamEntity(name, league.get());
            return teamRepository.save(teamDTO);
        }else {
            throw new RuntimeException();
        }
    }

    public void update(String name, Long teamId){
        Optional<TeamEntity> team = teamRepository.findById(teamId);
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
