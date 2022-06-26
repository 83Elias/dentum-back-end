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
import com.clinic.dentum.dto.PacientRequestDto;
import com.clinic.dentum.dto.PacientResponseDto;
import com.clinic.dentum.model.Pacient;
import com.clinic.dentum.service.PacientService;

@RestController
@RequestMapping("api/v1/pacient")
public class PacientController {

    @Autowired
    private PacientService pacientService;

    @PostMapping
    public ResponseEntity<Pacient> registerPacient(@RequestBody PacientRequestDto pacientRequestDto) {

        return ResponseEntity.ok(pacientService.registerPacient(pacientRequestDto));
    }

    @GetMapping(EndPoints.FIND_PACIENT)
    public ResponseEntity<PacientResponseDto> getPacient(@PathVariable(required = true) String dni) {

        return ResponseEntity.ok(pacientService.getPacientByDni(dni));
    }

    @GetMapping(EndPoints.FIND_ALL_PACIENTS)
    public ResponseEntity<List<Pacient>> getListPacients() {
        return ResponseEntity.ok(pacientService.getListPacient());
    }

    @Transactional
    @DeleteMapping(EndPoints.DELETE_PACIENT)
    public ResponseEntity<String> deletePacient(@PathVariable(required = true) String dni) {

        return ResponseEntity.ok(pacientService.removePacient(dni));
    }

    @PutMapping
    public ResponseEntity<Pacient> updatePacient(@RequestBody PacientRequestDto pacientRequestDto) {

        return ResponseEntity.ok(pacientService.updatePacient(pacientRequestDto));
    }

}
