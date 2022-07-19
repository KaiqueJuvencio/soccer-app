package com.br.soccerapp.repository;

import com.br.soccerapp.model.LeagueDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<LeagueDTO, Long> {
}
