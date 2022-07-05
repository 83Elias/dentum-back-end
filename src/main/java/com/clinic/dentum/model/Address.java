package com.clinic.dentum.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable{

    private static final long serialVersionUID = -7823476058458310071L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 150)
    private String street;

    @NotNull
    @Column(length = 20)
    private String number;

    @NotNull
    @Column(length = 100)
    private String location;

    @NotNull
    @Column(length = 60)
    private String provincie;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Pacient pacient;

}
