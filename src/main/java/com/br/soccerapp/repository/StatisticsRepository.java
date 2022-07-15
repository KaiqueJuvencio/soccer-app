package com.br.soccerapp.repository;

import com.br.soccerapp.model.PlayerDTO;
import com.br.soccerapp.model.StatisticsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<StatisticsDTO, String> {
}
