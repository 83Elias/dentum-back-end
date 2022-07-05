package com.clinic.dentum.constant;

public class EndPoints {

    private EndPoints() {
        throw new IllegalStateException("this class cannot be instantiated because it collects static members");
    }

    // end point for Pacient
    public static final String FIND_ALL_PACIENTS = "/pacients";
    public static final String FIND_PACIENT = "/{dni}";
    public static final String DELETE_PACIENT = "/{dni}";

    // end point for Dentist
    public static final String FIND_ALL_DENTISTS = "/dentists";
    public static final String FIND_DENTIST = "/{enrollment}";
    public static final String DELETE_DENTIST = "/{enrollment}";
    
    // end point for address
    public static final String DELETE_ADDRESS="/{dni}";
    public static final String FIND_ADDRESS="/{dni}";

    //end point for turn
    public static final String FIND_TURN_PACIENT="/{dni}";
    public static final String FIND_TURN_DENTIST="/{enrollment}";
}
