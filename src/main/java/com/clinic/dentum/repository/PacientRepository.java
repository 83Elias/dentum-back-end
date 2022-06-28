package com.clinic.dentum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.dentum.model.Pacient;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {

    Pacient findByDni(String dni);

    void deleteByDni(String dni);

}
