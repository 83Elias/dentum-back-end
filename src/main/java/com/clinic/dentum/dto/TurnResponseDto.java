package com.clinic.dentum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnResponseDto {

    private Long id;

    private String nameDentist;

    private String lastnameDentist;

    private String enrollment;

    private String namePacient;

    private String lastnamePacient;

    private String dni;

    private String dischargeDate;

    private String shiftDate;


}
