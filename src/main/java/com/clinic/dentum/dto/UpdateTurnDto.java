package com.clinic.dentum.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTurnDto {

    @NotNull
    private Long id;

    @NotNull
    private String dniPacient;

    @NotNull
    private String enrollmentDentist;

    @NotNull
    private String shiftDateTurn;

    @NotNull
    private String status;


}
