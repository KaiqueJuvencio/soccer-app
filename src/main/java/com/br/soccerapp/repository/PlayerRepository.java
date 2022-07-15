package com.br.soccerapp.repository;

import com.br.soccerapp.model.MatchDTO;
import com.br.soccerapp.model.PlayerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerDTO, String> {
}
