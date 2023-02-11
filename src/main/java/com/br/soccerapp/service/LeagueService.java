package com.br.soccerapp.service;

import com.br.soccerapp.exception.BadRequestException;
import com.br.soccerapp.exception.ObjectNullException;
import com.br.soccerapp.helper.Helper;
import com.br.soccerapp.model.LeagueDTO;
import com.br.soccerapp.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    @Autowired
    LeagueRepository leagueRepository;

    public List<LeagueDTO> list(){
        return leagueRepository.findAll();
    }

    public LeagueDTO create(String name){
        try{
            LeagueDTO league = new LeagueDTO(name);
            return leagueRepository.save(league);
        }catch (Exception e){
            throw new BadRequestException("Error to create League");
        }
    }

    public void update(LeagueDTO league){
        try {
            Optional<LeagueDTO> leagueResponse = leagueRepository.findById(league.getId());
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
            Optional<LeagueDTO> league = leagueRepository.findById(id);
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
