package com.clinic.dentum.constant;

public class EndPoints {

    private EndPoints() {
        throw new IllegalStateException("this class cannot be instantiated because it collects static members");
    }

    // end point for pacient
    public static final String FIND_ALL_PACIENTS = "/pacients";
    public static final String FIND_PACIENT = "/{dni}";
    public static final String UPDATE_PACIENT = "/update/pacient/{id}";
    public static final String DELETE_PACIENT = "/{dni}";

    // end point for
    public static final String FIND_ALL_DENTISTS = "/dentists";
    public static final String FIND_DENTIST = "/dentist";
    public static final String UPDATE_DENTIST = "/update/dentist/{id}";
    public static final String DELETE_DENTIST = "/dentist/{id}";

}
