package com.clinic.dentum.dto;

import java.time.LocalDate;

import com.clinic.dentum.model.Address;

public class PacientDto {

    private String name;
    private String lastname;
    private String dni;
    private LocalDate dischargDate;
    private Address address;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getDischargDate() {
        return this.dischargDate;
    }

    public void setDischargDate(LocalDate dischargDate) {
        this.dischargDate = dischargDate;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
}
