package com.clinic.dentum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clinic.dentum.model.AuthUser;
import com.clinic.dentum.repository.AuthRepository;

@Service
public class AuthService implements UserDetailsService{

    @Autowired
    AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
         AuthUser authUser=authRepository.findByUserName(username);

         if(authUser == null)
         {
           throw new UsernameNotFoundException("User not found with username {} "+username);
         }

        return authUser;
    }
    
}
