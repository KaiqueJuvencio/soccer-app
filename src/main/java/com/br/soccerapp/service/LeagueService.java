package com.br.soccerapp.service;

import com.br.soccerapp.model.LeagueDTO;
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

    public List<LeagueDTO> list(){
        return leagueRepository.findAll();
    }

    public LeagueDTO create(String name){
        LeagueDTO league = new LeagueDTO(name);
        return leagueRepository.save(league);
    }

    public void update(LeagueDTO league){
        Optional<LeagueDTO> leagueResponse = leagueRepository.findById(league.getId());
        if(leagueResponse.isPresent()){
            leagueResponse.get().setName(league.getName());
            leagueResponse.get().setStartDate(LocalDateTime.now());
            leagueRepository.save(leagueResponse.get());
        }
    }

    public void delete(Long id){
        leagueRepository.deleteById(id);
    }
}
