package com.clinic.dentum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.dentum.dto.TurnRequestDto;

import com.clinic.dentum.model.TurnPacientWithDentist;
import com.clinic.dentum.service.TurnService;

@RestController
@RequestMapping("api/v1/turn")
public class TurnController {

    @Autowired
    private TurnService turnService;

    @PostMapping
    public ResponseEntity<TurnPacientWithDentist> registerTurnPacient(@RequestBody TurnRequestDto turnRequestDto) {

        return ResponseEntity.ok(turnService.getTurnRegistered(turnRequestDto));
    }


}
