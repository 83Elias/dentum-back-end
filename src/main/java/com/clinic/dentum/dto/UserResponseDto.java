package com.clinic.dentum.dto;

import java.util.List;

import com.clinic.dentum.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseDto {

    private Long id;

    private String username;

    private String password;

    private Boolean enabled;

    private String dni;
    
    private List<Role> roles;

}
