package com.clinic.dentum.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequestDto {

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    @NotBlank
    private String location;

    @NotBlank
    private String provincie;

    private String dni;


}
