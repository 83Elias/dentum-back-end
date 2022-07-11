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
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import com.clinic.dentum.dto.TurnResponseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name="findTurn",
query="SELECT s.id,d.name as nameDentist,d.lastname as lastnameDentist,d.enrollment,p.name as namePacient,p.lastname as lastnamePacient,p.dni,p.discharge_date as dischargeDate,s.shift_date as shiftDate FROM shift_pacient_dentist s "+
"LEFT JOIN pacient p on s.pacient_id=p.id "+
"LEFT JOIN dentist d on s.dentist_id=d.id "+
"WHERE s.id=:id",
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

    @ManyToOne
    @JoinColumn(name ="pacient_id")
    @JsonBackReference("pacientReference")
    private Pacient pacient;

    @ManyToOne
    @JsonBackReference("dentistReference")
    @JoinColumn(name ="dentist_id")
    private Dentist dentist;
    
    @Column(name = "shift_date")
    private LocalDateTime shiftDate;

    @Column(name = "status")
    private String status;

}
