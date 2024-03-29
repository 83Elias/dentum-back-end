package com.clinic.dentum.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.clinic.dentum.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestDto {

    @NotNull
    private String username;
    
    @NotNull
    private String password;

    private Boolean enabled = true;

    @NotNull
    private String dni;

    @NotNull
    private List<Role> roles;

}
