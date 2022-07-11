package com.clinic.dentum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinic.dentum.dto.TurnResponseDto;
import com.clinic.dentum.model.TurnPacientWithDentist;

@Repository
public interface TurnRepository extends JpaRepository<TurnPacientWithDentist, Long> {

    @Query(name = "findTurn", nativeQuery = true)
    public TurnResponseDto findTurnById(@Param("id") Long id);
}
