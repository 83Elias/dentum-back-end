package com.clinic.dentum.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.clinic.dentum.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestDto {

    @NotBlank
    private String username;
    
    @NotBlank
    private String password;

    private Boolean enabled = true;

    @NotBlank
    private String dni;

    private List<Role> roles;

}
