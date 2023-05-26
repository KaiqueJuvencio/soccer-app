package com.br.soccerapp.repository;

import com.br.soccerapp.model.entity.Statistics;
import com.br.soccerapp.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    public Optional<Statistics> findByTeam(Team team);
}
