package com.br.soccerapp.service;

import com.br.soccerapp.entity.MatchEntity;
import com.br.soccerapp.entity.TeamEntity;
import com.br.soccerapp.repository.MatchRepository;
import com.br.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepository matchRepository;

    public List<MatchEntity> list(){
        return matchRepository.findAll();
    }

    public MatchEntity create(Long homeTeamId, Long awayTeamId){
        Optional<TeamEntity> homeTeam = teamRepository.findById(homeTeamId);
        Optional<TeamEntity> awayTeam = teamRepository.findById(awayTeamId);
        if(homeTeam.isPresent() && awayTeam.isPresent()){
            MatchEntity matchDTO = new MatchEntity(homeTeam.get(), awayTeam.get());
            return matchRepository.save(matchDTO);
        }else {
            throw new RuntimeException();
        }
    }

    public void update(Long matchId, Long homeTeamId, Long awayTeamId){
        Optional<MatchEntity> match = matchRepository.findById(matchId);
        Optional<TeamEntity> homeTeam = teamRepository.findById(homeTeamId);
        Optional<TeamEntity> awayTeam = teamRepository.findById(awayTeamId);
        if(match.isPresent() && homeTeam.isPresent() && awayTeam.isPresent()){
            match.get().setTeamHome(homeTeam.get());
            match.get().setTeamVisitor(awayTeam.get());
            matchRepository.save(match.get());
        }else {
            throw new RuntimeException();
        }
    }

    public void delete(Long id){
        matchRepository.deleteById(id);
    }
}
