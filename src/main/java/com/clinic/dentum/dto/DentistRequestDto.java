package com.clinic.dentum.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotBlank
    private String enrollment;
}
