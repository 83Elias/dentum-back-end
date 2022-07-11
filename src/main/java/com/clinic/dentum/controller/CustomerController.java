package com.clinic.dentum.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.dentum.constant.EndPoints;
import com.clinic.dentum.dto.UserRequestDto;
import com.clinic.dentum.dto.UserResponseDto;
import com.clinic.dentum.model.Customer;
import com.clinic.dentum.service.AuthService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private AuthService authService;

    @PostMapping(EndPoints.REGISTER)
    public Customer register(@RequestBody UserRequestDto userRequestDto) {

        return authService.register(userRequestDto);
    }

    @PutMapping(EndPoints.UPDATE_USER)
    public Customer updateUser(@RequestBody UserRequestDto userRequestDto) {
        return authService.updateUser(userRequestDto);
    }

    @Transactional
    @DeleteMapping(EndPoints.DELETE_USER)
    public String deleteUser(@PathVariable String dni){
         
        return authService.deleteUser(dni);
    }
}
