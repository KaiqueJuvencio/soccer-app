package com.br.soccerapp.service;

import com.br.soccerapp.exception.ObjectNullException;
import com.br.soccerapp.model.dto.TeamDTO;
import com.br.soccerapp.model.entity.League;
import com.br.soccerapp.model.entity.Team;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    LeagueService leagueService;

    public List<TeamDTO> list(){
        return teamRepository.findAll().stream()
                .map(Team::toDTO)
                .collect(Collectors.toList());
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
