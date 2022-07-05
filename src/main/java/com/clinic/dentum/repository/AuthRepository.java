package com.clinic.dentum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.dentum.model.AuthUser;

@Repository
public interface AuthRepository extends JpaRepository<AuthUser,Long> {
    
   AuthUser findByUserName(String username);
}
