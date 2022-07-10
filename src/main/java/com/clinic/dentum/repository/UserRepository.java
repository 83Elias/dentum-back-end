package com.clinic.dentum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.dentum.model.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer,Long> {
    
     
    Customer findByUsername(String username);
    
    Customer findByUsernameAndPassword(String username,String password);

    Customer findByDni(String dni);

    void deleteByDni(String dni);
}
