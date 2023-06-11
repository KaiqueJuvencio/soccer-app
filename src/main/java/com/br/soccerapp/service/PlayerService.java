package com.br.soccerapp.service;

import com.br.soccerapp.exception.ObjectNullException;
import com.br.soccerapp.model.dto.PlayerDTO;
import com.br.soccerapp.model.entity.Player;
import com.br.soccerapp.model.entity.Team;
import com.br.soccerapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    TeamService teamService;

    @Autowired
    PlayerRepository playerRepository;

    public List<PlayerDTO> list(){
        return playerRepository.findAll()
                .stream()
                .map(Player::toDTO)
                .collect(Collectors.toList());
    }

    public Player findById(Long id){
        return playerRepository.findById(id).orElseThrow(()-> new ObjectNullException("Player not exist"));
    }

    public void create(String name, Long teamId){
        Team team = teamService.findById(teamId);
        playerRepository.save(new Player(name, team));
    }

    public void update(String name, Long playerId, Long teamId){
        Player player = this.findById(playerId);
        Team team = teamService.findById(teamId);
        player.setName(name);
        player.setTeam(team);
        playerRepository.save(player);
    }

    public void delete(Long id){
        this.findById(id);
        playerRepository.deleteById(id);
    }
}
