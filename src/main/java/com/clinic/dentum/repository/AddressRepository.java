package com.clinic.dentum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.dentum.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    
}
