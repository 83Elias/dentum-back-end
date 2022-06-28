package com.clinic.dentum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.dentum.constant.EndPoints;
import com.clinic.dentum.dto.DentistRequestDto;
import com.clinic.dentum.dto.DentistResponseDto;
import com.clinic.dentum.model.Dentist;
import com.clinic.dentum.service.DentistService;

@RestController
@RequestMapping("api/v1/dentist")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @PostMapping
    public ResponseEntity<Dentist> registerDentist(@RequestBody DentistRequestDto dentistRequestDto) {

        return ResponseEntity.ok(dentistService.registerDentist(dentistRequestDto));
    }

    @GetMapping(EndPoints.FIND_DENTIST)
    public ResponseEntity<DentistResponseDto> getDentist(@PathVariable(required = true) String enrollment) {

        return ResponseEntity.ok(dentistService.getDentistByEnrollment(enrollment));
    }

    @GetMapping(EndPoints.FIND_ALL_DENTISTS)
    public ResponseEntity<List<Dentist>> getListDentist() {
        return ResponseEntity.ok(dentistService.getListDentist());
    }

    @Transactional
    @DeleteMapping(EndPoints.DELETE_DENTIST)
    public ResponseEntity<String> deleteDentist(@PathVariable(required = true) String enrollment) {

        return ResponseEntity.ok(dentistService.removeDentist(enrollment));
    }

    @PutMapping
    public ResponseEntity<Dentist> updateDentist(@RequestBody DentistRequestDto dentistRequestDto) {

        return ResponseEntity.ok(dentistService.updateDentist(dentistRequestDto));
    }
}
