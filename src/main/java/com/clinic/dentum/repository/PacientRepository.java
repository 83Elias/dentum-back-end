package com.clinic.dentum.repository;

import org.springframework.data.repository.CrudRepository;

import com.clinic.dentum.model.Pacient;

public interface PacientRepository extends CrudRepository<Pacient,Integer>{
    
}
