package com.br.soccerapp.service;

import com.br.soccerapp.entity.LeagueEntity;
import com.br.soccerapp.exceptionhandler.exceptions.BadRequestException;
import com.br.soccerapp.exceptionhandler.exceptions.ObjectNullException;
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

    public List<LeagueEntity> list(){
        return leagueRepository.findAll();
    }

    public LeagueEntity create(String name){
        LeagueEntity league = new LeagueEntity(name);
        return leagueRepository.save(league);
    }

    public void update(Long id, String name){
        try{
            Optional<LeagueEntity> leagueResponse = leagueRepository.findById(id);
            verifyLeagueExist(leagueResponse);
            leagueResponse.get().setName(name);
            leagueResponse.get().setStartDate(LocalDateTime.now());
            leagueRepository.save(leagueResponse.get());
        }catch (ObjectNullException e){
            throw new ObjectNullException("League not exist");
        }
        catch (Exception e){
            throw new BadRequestException("Error to delete league");
        }
    }

    public void delete(Long id){
        try{
            Optional<LeagueEntity> leagueResponse = leagueRepository.findById(id);
            verifyLeagueExist(leagueResponse);
            leagueRepository.deleteById(id);
        }catch (ObjectNullException e){
            throw new ObjectNullException("League not exist");
        }
        catch (Exception e){
            throw new BadRequestException("Error to delete league");
        }
    }

    public void verifyLeagueExist(Optional<LeagueEntity> league) {
        if(league.isEmpty()) throw new ObjectNullException("");
    }
}
