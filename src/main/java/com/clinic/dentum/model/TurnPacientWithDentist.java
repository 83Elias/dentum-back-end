package com.clinic.dentum.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.clinic.dentum.dto.TurnResponseDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name="findTurnPacients",
query="SELECT s.id,d.name as nameDentist,d.lastname as lastnameDentist,d.enrollment,p.name as namePacient,p.lastname as lastnamePacient,p.dni,p.discharge_date as dischargeDate,s.shift_date as shiftDate FROM shift_pacient_dentist s "+
"LEFT JOIN pacient p on s.id_dentist=p.id "+
"LEFT JOIN dentist d on s.id_pacient=d.id "+
"WHERE s.id_pacient=:id",
resultSetMapping = "Mapping.TurnResponseDto"
)
@SqlResultSetMapping(
    name="Mapping.TurnResponseDto",
    classes = @ConstructorResult(targetClass = TurnResponseDto.class,
    columns ={
        @ColumnResult(name = "id",type = Long.class),
        @ColumnResult(name = "nameDentist",type = String.class),
        @ColumnResult(name = "lastnameDentist",type = String.class),
        @ColumnResult(name = "enrollment",type = String.class),
        @ColumnResult(name = "namePacient",type = String.class),
        @ColumnResult(name = "lastnamePacient",type = String.class),
        @ColumnResult(name = "dni",type = String.class),
        @ColumnResult(name = "dischargeDate",type = String.class),
        @ColumnResult(name = "shiftDate",type = String.class),
    })
)

@NamedNativeQuery(name="findTurnDentist",
query="SELECT s.id,d.name as nameDentist,d.lastname as lastnameDentist,d.enrollment,p.name as namePacient,p.lastname as lastnamePacient,p.dni,p.discharge_date as dischargeDate,s.shift_date as shiftDate FROM shift_pacient_dentist s "+
"LEFT JOIN pacient p on s.id_dentist=p.id "+
"LEFT JOIN dentist d on s.id_pacient=d.id "+
"WHERE s.id_dentist=:id",
resultSetMapping = "Mapping.TurnResponseDtoDentist"
)
@SqlResultSetMapping(
    name="Mapping.TurnResponseDtoDentist",
    classes = @ConstructorResult(targetClass = TurnResponseDto.class,
    columns ={
        @ColumnResult(name = "id",type = Long.class),
        @ColumnResult(name = "nameDentist",type = String.class),
        @ColumnResult(name = "lastnameDentist",type = String.class),
        @ColumnResult(name = "enrollment",type = String.class),
        @ColumnResult(name = "namePacient",type = String.class),
        @ColumnResult(name = "lastnamePacient",type = String.class),
        @ColumnResult(name = "dni",type = String.class),
        @ColumnResult(name = "dischargeDate",type = String.class),
        @ColumnResult(name = "shiftDate",type = String.class),
    })
)


@Data
@NoArgsConstructor
@Entity
@Table(name = "shift_pacient_dentist")
public class TurnPacientWithDentist implements Serializable {

    private static final long serialVersionUID = 8980059635814978909L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pacient", referencedColumnName = "id")
    private Pacient pacient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dentist", referencedColumnName = "id")
    private Dentist dentist;

    @Column(name = "shift_date")
    private LocalDateTime shiftDate;

    @Column(name = "status")
    private String status;

}
