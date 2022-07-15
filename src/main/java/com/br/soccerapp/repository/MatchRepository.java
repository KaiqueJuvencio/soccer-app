package com.br.soccerapp.repository;

import com.br.soccerapp.model.LeagueDTO;
import com.br.soccerapp.model.MatchDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchDTO, String> {
}
