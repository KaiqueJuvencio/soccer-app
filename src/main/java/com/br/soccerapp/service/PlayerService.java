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

    public List<PlayerDTO> list(){
        return playerRepository.findAll();
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

    public void update(String name, Long playerId, Long teamId){
        Optional<PlayerDTO> player = playerRepository.findById(playerId);
        Optional<TeamDTO> team = teamRepository.findById(teamId);
        if(player.isPresent() && team.isPresent()){
            player.get().setName(name);
            player.get().setTeam(team.get());
            playerRepository.save(player.get());
        }else {
            throw new RuntimeException();
        }
    }

    public void delete(Long id){
        playerRepository.deleteById(id);
    }
}
