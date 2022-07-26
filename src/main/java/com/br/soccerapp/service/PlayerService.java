package com.br.soccerapp.service;

import com.br.soccerapp.model.LeagueDTO;
import com.br.soccerapp.model.PlayerDTO;
import com.br.soccerapp.model.TeamDTO;
import com.br.soccerapp.repository.LeagueRepository;
import com.br.soccerapp.repository.PlayerRepository;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerRepository;

    public List<TeamDTO> list(){
        return teamRepository.findAll();
    }

    public PlayerDTO create(String name, Long teamId){
        Optional<TeamDTO> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            PlayerDTO player = new PlayerDTO(name, team.get());
            return playerRepository.save(player);
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
