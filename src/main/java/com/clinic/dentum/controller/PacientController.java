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
import com.clinic.dentum.dto.PacientDto;
import com.clinic.dentum.model.Pacient;
import com.clinic.dentum.service.PacientService;

@RestController(value = "api/v1")
public class PacientController {


    @Autowired
    private PacientService pacientService;



    @PostMapping(EndPoints.CREATE_PACIENT)
    public ResponseEntity<Pacient> findPacientById(@RequestBody PacientDto pacientDto ) {
        

        return null;
    }
    
    
    @GetMapping(EndPoints.FIND_ALL_PACIENTS)
    public ResponseEntity<List<Pacient>> getAllPacient( ) {
        

        return null;
    } 
    
    @GetMapping(EndPoints.FIND_PACIENT)
    public ResponseEntity<Pacient> getPacient( ) {
        

        return null;
    } 
    
    
    @PutMapping(EndPoints.UPDATE_PACIENT)
    public ResponseEntity<Pacient> modifyPacient(@PathVariable("id") Integer id) {
        

        return null;
    } 
    
    @DeleteMapping(EndPoints.DELETE_PACIENT)
    public ResponseEntity<HttpStatus> deletePacient(@PathVariable("id") Integer id) {
        

        return null;
    } 
    
}
