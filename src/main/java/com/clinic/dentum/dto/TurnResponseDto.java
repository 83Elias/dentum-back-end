package com.clinic.dentum.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnResponseDto {

    private Long id;

    private PacientResponseDto pacientResponseDto;

    private DentistResponseDto dentistResponseDto;

    private String shiftDate;

    private String status;

}
