package com.br.soccerapp.service;

import com.br.soccerapp.exception.BadRequestException;
import com.br.soccerapp.exception.ObjectNullException;
import com.br.soccerapp.model.entity.League;
import com.br.soccerapp.model.entity.Team;
import com.br.soccerapp.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public League create(String name){
        try{
            League league = new League(name);
            return leagueRepository.save(league);
        }catch (Exception e){
            throw new BadRequestException("Error to create League");
        }
    }

    public void update(League league){
        try {
            Optional<League> leagueResponse = leagueRepository.findById(league.getId());
            this.verifyIsNull(leagueResponse);
            leagueResponse.get().setName(league.getName());
            leagueResponse.get().setStartDate(LocalDateTime.now());
            leagueRepository.save(leagueResponse.get());
        }catch (ObjectNullException e){
            throw new ObjectNullException("League not exist");
        }catch (Exception e) {
            throw new BadRequestException("Error to update League");
        }
    }

    public void delete(Long id){
        try{
            Optional<League> league = leagueRepository.findById(id);
            this.verifyIsNull(league);
            leagueRepository.deleteById(id);
        }catch (ObjectNullException e){
            throw new ObjectNullException("League not exist");
        }catch (Exception e) {
            throw new BadRequestException("Error to delete League");
        }
    }

    public void verifyIsNull(Optional<?> method){
        if(method.isEmpty()) throw new ObjectNullException("");
    }
}
