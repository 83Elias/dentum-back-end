package com.clinic.dentum.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "shift_pacient_dentist")
public class TurnPacientWithDentist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pacient")
    private Pacient pacient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dentist")
    private Dentist dentist;

    @Column(name = "shift_date")
    private LocalDateTime shiftDate;

    @Column(name = "status")
    private String status;

}
