package com.clinic.dentum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.dentum.model.Pacient;

public interface PacientRepository extends JpaRepository<Pacient, Long> {

    Pacient findByDni(String dni);

    void deleteByDni(String dni);

}
