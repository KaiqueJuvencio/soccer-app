package com.br.soccerapp.service;

import com.br.soccerapp.exception.BadRequestException;
import com.br.soccerapp.exception.ObjectNullException;
import com.br.soccerapp.model.entity.Player;
import com.br.soccerapp.model.entity.Team;
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

    public List<Player> list(){
        return playerRepository.findAll();
    }

    public Player create(String name, Long teamId){
        try{
            Optional<Team> team = teamRepository.findById(teamId);
            this.verifyIsNull(team);
            Player player = new Player(name, team.get());
            return playerRepository.save(player);
        }catch (ObjectNullException e){
            throw new ObjectNullException("Team not exist");
        }catch (Exception e){
            throw new BadRequestException("Error to create Player");
        }
    }

    public void update(String name, Long playerId, Long teamId){
        try{
            Optional<Player> player = playerRepository.findById(playerId);
            this.verifyIsNull(player);
            Optional<Team> team = teamRepository.findById(teamId);
            this.verifyIsNull(team);
            player.get().setName(name);
            player.get().setTeam(team.get());
            playerRepository.save(player.get());
        }catch (ObjectNullException e){
            throw new ObjectNullException("Team or Player not exist");
        }catch (Exception e) {
            throw new BadRequestException("Error to update Player");
        }
    }

    public void delete(Long id){
        try{
            Optional<Player> player = playerRepository.findById(id);
            this.verifyIsNull(player);
            playerRepository.deleteById(id);
        }catch (ObjectNullException e){
            throw new ObjectNullException("Player not exist");
        }catch (Exception e) {
            throw new BadRequestException("Error to delete Player");
        }
    }

    public void verifyIsNull(Optional<?> method){
        if(method.isEmpty()) throw new ObjectNullException("");
    }
}
