package com.clinic.dentum.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.clinic.dentum.model.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacientRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotBlank
    private String dni;
    
    private LocalDate dischargeDate;

    private Address address;
}
