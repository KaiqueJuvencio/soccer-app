package com.br.soccerapp.service;

import com.br.soccerapp.entity.LeagueEntity;
import com.br.soccerapp.entity.TeamEntity;
import com.br.soccerapp.exceptionhandler.exceptions.BadRequestException;
import com.br.soccerapp.exceptionhandler.exceptions.ObjectNullException;
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
        try{
            Optional<TeamEntity> team = teamRepository.findById(teamId);
            verifyTeamExist(team);
            team.get().setName(name);
            teamRepository.save(team.get());
        }catch (ObjectNullException e){
            throw new ObjectNullException("Team not exist");
        }
        catch (Exception e){
            throw new BadRequestException("Team to delete league");
        }
    }

    public void delete(Long id){
        teamRepository.deleteById(id);
    }

    public void verifyTeamExist(Optional<TeamEntity> team) {
        if(team.isEmpty()) throw new ObjectNullException("");
    }
}
