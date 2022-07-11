package com.clinic.dentum.dto;

import java.util.List;

import com.clinic.dentum.model.TurnPacientWithDentist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistResponseDto {

    private Long id;

    private String name;

    private String lastname;

    private String enrollment;

    private List<TurnPacientWithDentist> turns;
}
