package com.clinic.dentum.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pacient")
public class Pacient implements Serializable {

    private static final long serialVersionUID = 6146705628976841832L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 60)
    private String name;

    @NotNull
    @Column(length = 60)
    private String lastname;

    @NotNull
    @Column(length = 12, unique = true)
    private String dni;

    @Column(name = "discharge_date")
    private LocalDate dischargeDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
  
    @OneToMany(mappedBy = "pacient", orphanRemoval = true)
    @JsonManagedReference("pacientReference")
    private List<TurnPacientWithDentist> turns;

}
