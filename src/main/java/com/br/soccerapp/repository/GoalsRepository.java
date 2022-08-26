package com.br.soccerapp.repository;

import com.br.soccerapp.entity.GoalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalsRepository extends JpaRepository<GoalsEntity, Long> {
}
