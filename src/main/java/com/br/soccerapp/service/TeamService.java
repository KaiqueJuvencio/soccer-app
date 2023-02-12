package com.br.soccerapp.service;

import com.br.soccerapp.exception.BadRequestException;
import com.br.soccerapp.exception.ObjectNullException;
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
        try{
            Optional<LeagueDTO> league = leagueRepository.findById(leagueId);
            this.verifyIsNull(league);
            TeamDTO teamDTO = new TeamDTO(name, league.get());
            return teamRepository.save(teamDTO);
        }catch (ObjectNullException e){
            throw new ObjectNullException("League not exist");
        }catch (Exception e) {
            throw new BadRequestException("Error to create Team");
        }
    }

    public void update(String name, Long teamId){
        try{
            Optional<TeamDTO> team = teamRepository.findById(teamId);
            this.verifyIsNull(team);
            team.get().setName(name);
            teamRepository.save(team.get());
        }catch (ObjectNullException e){
            throw new ObjectNullException("Team not exist");
        }catch (Exception e) {
            throw new BadRequestException("Error to update Team");
        }
    }

    public void delete(Long id){
        try {
            Optional<TeamDTO> team = teamRepository.findById(id);
            this.verifyIsNull(team);
            teamRepository.deleteById(id);
        }catch (ObjectNullException e){
            throw new ObjectNullException("Team not exist");
        }catch (Exception e) {
            throw new BadRequestException("Error to delete Team");
        }
    }

    public void verifyIsNull(Optional<?> method){
        if(method.isEmpty()) throw new ObjectNullException("");
    }
}
