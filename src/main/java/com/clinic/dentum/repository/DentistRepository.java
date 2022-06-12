package com.clinic.dentum.repository;

import org.springframework.data.repository.CrudRepository;

import com.clinic.dentum.model.Dentist;

public interface DentistRepository extends CrudRepository<Dentist, Integer> {

}
