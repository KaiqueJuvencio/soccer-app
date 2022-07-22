package com.br.soccerapp.repository;

import com.br.soccerapp.model.TeamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamDTO, Long> {
}
