package com.clinic.dentum.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurnRequestDto {
    
    @NotBlank
    private String dniPacient;

    @NotBlank
    private String enrollmentDentist;

    @NotBlank
    private String shiftDateTurn;

    private String status="A";
}
