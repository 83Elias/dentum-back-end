package com.clinic.dentum.dto;

import java.time.LocalDate;

import com.clinic.dentum.model.Address;

import lombok.Data;

@Data
public class PacientResponseDto {
    
    private Integer id;
    private String name;
    private String lastname;
    private String dni;
    private LocalDate dischargDate;
    private Address address;

}
