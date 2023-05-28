package com.br.soccerapp.service;

import com.br.soccerapp.exception.ObjectNullException;
import com.br.soccerapp.model.entity.League;
import com.br.soccerapp.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeagueService {

    @Autowired
    LeagueRepository leagueRepository;

    public List<League> list(){
        return leagueRepository.findAll();
    }

    public League findById(Long id){
        return leagueRepository.findById(id).orElseThrow(()-> new ObjectNullException("League not exist"));
    }

    public void create(String name){
        leagueRepository.save(new League(name));
    }

    public void update(League league){
        League leagueResponse = this.findById(league.getId());
        leagueResponse.setName(league.getName());
        leagueResponse.setStartDate(LocalDateTime.now());
        leagueRepository.save(leagueResponse);
    }

    public void delete(Long id){
        this.findById(id);
        leagueRepository.deleteById(id);
    }
}
