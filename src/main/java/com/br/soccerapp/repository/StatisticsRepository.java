package com.br.soccerapp.repository;

import com.br.soccerapp.model.PlayerDTO;
import com.br.soccerapp.model.StatisticsDTO;
import com.br.soccerapp.model.TeamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<StatisticsDTO, Long> {
    public Optional<StatisticsDTO> findByTeam(TeamDTO team);
}
