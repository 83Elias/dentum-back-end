package com.clinic.dentum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.dentum.constan.EndPoints;
import com.clinic.dentum.model.Dentist;
import com.clinic.dentum.service.DentistService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController(value = "api/v1")
public class DentistController {

    @Autowired
    private DentistService dentistService;



    @PostMapping(EndPoints.CREATE_DENTIST)
    public ResponseEntity<Dentist> findDentistById( ) {
        

        return null;
    }
    
    
    @GetMapping(EndPoints.FIND_ALL_DENTISTS)
    public ResponseEntity<List<Dentist>> getAllDentist( ) {
        

        return null;
    } 
    
    @GetMapping(EndPoints.FIND_DENTIST)
    public ResponseEntity<Dentist> getDentist( ) {
        

        return null;
    } 
    
    
    @PutMapping(EndPoints.UPDATE_DENTIST)
    public ResponseEntity<Dentist> modifyDentist(@PathVariable("id") Integer id) {
        

        return null;
    } 
    
    @DeleteMapping(EndPoints.DELETE_DENTIST)
    public ResponseEntity<HttpStatus> deleteDentist(@PathVariable("id") Integer id) {
        

        return null;
    } 



    

    
 
    

}
