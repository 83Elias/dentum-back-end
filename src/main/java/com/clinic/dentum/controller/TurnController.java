package com.clinic.dentum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.clinic.dentum.dto.TurnRequestDto;
import com.clinic.dentum.dto.TurnResponseDto;
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

    @GetMapping
    public ResponseEntity<List<TurnResponseDto>> downloadTurn(@RequestParam(required = false) String dni,@RequestParam(required = false) String enrollment) {
        return ResponseEntity.ok(turnService.findTurn(dni,enrollment));
    }


}
