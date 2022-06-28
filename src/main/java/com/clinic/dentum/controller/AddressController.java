package com.clinic.dentum.controller;

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
import com.clinic.dentum.dto.AddressRequestDto;
import com.clinic.dentum.dto.AddressResponseDto;
import com.clinic.dentum.model.Pacient;
import com.clinic.dentum.service.AddressService;

@RestController
@RequestMapping("api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Pacient> registerAddress(@RequestBody AddressRequestDto addressDto) {

        return ResponseEntity.ok(addressService.registerAddress(addressDto));
    }

    @GetMapping(EndPoints.FIND_ADDRESS)
    public ResponseEntity<AddressResponseDto> getAddressByDniPacient(@PathVariable(required = true) String dni){
        return ResponseEntity.ok(addressService.getAddressByPacient(dni));
    }

    @PutMapping
    public ResponseEntity<AddressResponseDto> updateAddressByDniPacient(@RequestBody AddressRequestDto addressRequestDto){
        return ResponseEntity.ok(addressService.updateAddresByPacient(addressRequestDto));
    }

    @Transactional
    @DeleteMapping(EndPoints.DELETE_ADDRESS)
    public ResponseEntity<String> deleteAddress(@PathVariable(required = true) String dni){
        
        return ResponseEntity.ok(addressService.removeAddress(dni));
    }

}
