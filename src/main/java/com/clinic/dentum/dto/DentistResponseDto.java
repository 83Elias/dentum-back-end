package com.clinic.dentum.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistResponseDto {

    private Long id;

    private String name;


    private String lastname;


    private String enrollment;
}
