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

    
    @Query(name = "findTurnPacients", nativeQuery = true)
    public List<TurnResponseDto> getTurnByIdPacient(@Param("id") Long id);

    @Query(name = "findTurnDentist", nativeQuery = true)
    public List<TurnResponseDto> getTurnByIdDentist(@Param("id") Long id);
}
