package com.clinic.dentum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.dentum.constant.EndPoints;
import com.clinic.dentum.dto.TurnRequestDto;
import com.clinic.dentum.dto.TurnResponseDto;
import com.clinic.dentum.dto.UpdateTurnDto;
import com.clinic.dentum.model.TurnPacientWithDentist;
import com.clinic.dentum.service.TurnService;

@RestController
@RequestMapping("api/v1/turn")
public class TurnController {

    @Autowired
    private TurnService turnService;

    @PostMapping
    public ResponseEntity<TurnPacientWithDentist> registerTurn(@RequestBody TurnRequestDto turnRequestDto) {

        return ResponseEntity.ok(turnService.getTurnRegistered(turnRequestDto));
    }

    @GetMapping(EndPoints.FIND_TURN)
    public ResponseEntity<TurnResponseDto> downloadTurn(@PathVariable Long id) {
        return ResponseEntity.ok(turnService.findTurn(id));
    }

    @PutMapping
    public ResponseEntity<TurnPacientWithDentist> updateTurn(@RequestBody UpdateTurnDto updateTurnDto ){

        return ResponseEntity.ok(turnService.updateTurn(updateTurnDto));
    }

    @DeleteMapping(EndPoints.DELETE_TURN)
    public ResponseEntity<String> deleteTurn(@PathVariable Long id) {

        return ResponseEntity.ok(turnService.deleteTurn(id));
    }
}
