package com.clinic.dentum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.dentum.model.TurnPacientWithDentist;

@Repository
public interface TurnRepository extends JpaRepository<TurnPacientWithDentist,Long> {
    
}
