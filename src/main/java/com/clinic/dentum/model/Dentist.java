package com.clinic.dentum.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dentist")
public class Dentist implements Serializable {

    private static final long serialVersionUID = 8752767413734612948L;
    
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
    private String enrollment;
    
    @OneToMany(mappedBy = "dentist", orphanRemoval = true)
    @JsonManagedReference("dentistReference")
    private List<TurnPacientWithDentist> turns;


}
