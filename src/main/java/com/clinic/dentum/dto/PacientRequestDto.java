package com.clinic.dentum.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacientRequestDto {

    private String name;
    private String lastname;
    private String dni;
    private LocalDate dischargeDate;
}
