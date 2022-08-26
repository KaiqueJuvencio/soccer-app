package com.br.soccerapp.service;

import com.br.soccerapp.entity.PlayerEntity;
import com.br.soccerapp.entity.TeamEntity;
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

    public List<PlayerEntity> list(){
        return playerRepository.findAll();
    }

    public PlayerEntity create(String name, Long teamId){
        Optional<TeamEntity> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            PlayerEntity player = new PlayerEntity(name, team.get());
            return playerRepository.save(player);
        }else {
            throw new RuntimeException();
        }
    }

    public void update(String name, Long playerId, Long teamId){
        Optional<PlayerEntity> player = playerRepository.findById(playerId);
        Optional<TeamEntity> team = teamRepository.findById(teamId);
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
