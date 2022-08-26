package com.br.soccerapp.repository;

import com.br.soccerapp.entity.StatisticsEntity;
import com.br.soccerapp.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<StatisticsEntity, Long> {
    public Optional<StatisticsEntity> findByTeam(TeamEntity team);
}
