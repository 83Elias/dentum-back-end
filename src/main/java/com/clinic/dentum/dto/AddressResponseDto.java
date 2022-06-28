package com.clinic.dentum.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressResponseDto {

    private Long id;

    private String street;

    private String number;

    private String location;

    private String provincie;
}
