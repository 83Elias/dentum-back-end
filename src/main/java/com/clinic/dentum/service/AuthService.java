package com.clinic.dentum.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinic.dentum.dto.UserRequestDto;
import com.clinic.dentum.dto.UserResponseDto;
import com.clinic.dentum.model.Customer;
import com.clinic.dentum.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuthService {

    private static final Logger logger = LogManager.getLogger(AuthService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserResponseDto login(String username) {

        try {
            if (username == null ) {
                logger.error("error to login, the username or password is empty");
            }

            return mapper.convertValue(userRepository.findByUsername(username),
                    UserResponseDto.class);
        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    public Customer register(UserRequestDto userRequestDto) {

        try {

            if (!Objects.isNull(userRequestDto)) {

                Customer customer = mapper.convertValue(userRequestDto, Customer.class);
                customer.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
                return userRepository.save(customer);
            }

        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    public Customer updateUser(UserRequestDto userRequestDto) {
        Customer user = null;
        try {

            if (!Objects.isNull(userRequestDto)) {

                user = userRepository.findByDni(userRequestDto.getDni());

                if (!Objects.isNull(user)) {

                    user.setUsername(userRequestDto.getUsername());
                    user.setPassword(userRequestDto.getPassword());
                    user.setRoles(userRequestDto.getRoles());
                    user.setEnabled(userRequestDto.getEnabled());

                    return userRepository.save(user);
                }

            }

        } catch (Exception e) {
            logger.error("not found user with dni {}", userRequestDto.getDni());

            logger.error(e);
        }

        return user;
    }

    public String deleteUser(String dni) {

        try {

            if (dni == null) {
                logger.info("dni is null impossible deleting user");
            }

            userRepository.deleteByDni(dni);
            return "success";

        } catch (Exception e) {
            logger.error(e);
        }

        return "error to deleting user";
    }
}
