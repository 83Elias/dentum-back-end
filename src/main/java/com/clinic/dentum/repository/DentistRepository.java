package com.clinic.dentum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.dentum.model.Dentist;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {


    Dentist findByEnrollment(String enrollment);

    void deleteByEnrollment(String enrollment);
    
}
