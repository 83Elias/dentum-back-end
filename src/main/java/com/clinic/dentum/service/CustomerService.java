package com.clinic.dentum.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.clinic.dentum.interfaces.ICustomerService;
import com.clinic.dentum.model.Customer;
import com.clinic.dentum.repository.UserRepository;

@Transactional
@Service
public class CustomerService implements ICustomerService, UserDetailsService {

    private static final Logger logger = LogManager.getLogger(CustomerService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = userRepository.findByUsername(username);

        if (customer == null) {
            logger.error("Error to login the username: {} not found", username);
            throw new UsernameNotFoundException("Error to login the username " + username + " not found");
        }

        List<GrantedAuthority> authorities = customer.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .peek(authority -> logger.info("one user with rol {} is loged", authority.getAuthority()))
                .collect(Collectors.toList());

        logger.info("user authenticated {}", customer.getUsername());

        return new User(customer.getUsername(), customer.getPassword(), customer.getEnabled(),
                true, true, true, authorities);
    }

    @Override
    public Customer findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

}
