package com.br.soccerapp.service;

import com.br.soccerapp.exception.ObjectNullException;
import com.br.soccerapp.model.entity.League;
import com.br.soccerapp.model.entity.Team;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    LeagueService leagueService;

    public List<Team> list(){
        return teamRepository.findAll();
    }

    public Team findById(Long id){
        return teamRepository.findById(id).orElseThrow(()-> new ObjectNullException("Team not exist"));
    }

    public void create(String name, Long leagueId){
        League league = leagueService.findById(leagueId);
        teamRepository.save(new Team(name, league));
    }

    public void update(String name, Long teamId){
        Team team = this.findById(teamId);
        team.setName(name);
        teamRepository.save(team);
    }

    public void delete(Long id){
        this.findById(id);
        teamRepository.deleteById(id);
    }
}
