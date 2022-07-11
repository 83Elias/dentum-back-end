package com.clinic.dentum.dto;

import java.time.LocalDate;
import java.util.List;

import com.clinic.dentum.model.Address;
import com.clinic.dentum.model.TurnPacientWithDentist;

import lombok.Data;

@Data
public class PacientResponseDto {
    
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private LocalDate dischargDate;
    private Address address;
    private List<TurnPacientWithDentist> turns;

}
