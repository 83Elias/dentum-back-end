package com.clinic.dentum.constan;

public class EndPoints {

    // end point for pacient
    public static final String CREATE_PACIENT = "/register/pacient";
    public static final String FIND_ALL_PACIENTS = "/pacients";
    public static final String FIND_PACIENT = "/pacient";
    public static final String UPDATE_PACIENT = "/update/pacient/{id}";
    public static final String DELETE_PACIENT = "/pacient/{id}";

    // end point for
    public static final String CREATE_DENTIST = "/register/dentist";
    public static final String FIND_ALL_DENTISTS = "/dentists";
    public static final String FIND_DENTIST = "/dentist";
    public static final String UPDATE_DENTIST = "/update/dentist/{id}";
    public static final String DELETE_DENTIST = "/dentist/{id}";

}
