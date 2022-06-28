package com.clinic.dentum.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.dentum.dto.AddressRequestDto;
import com.clinic.dentum.dto.AddressResponseDto;
import com.clinic.dentum.model.Address;
import com.clinic.dentum.model.Pacient;
import com.clinic.dentum.repository.AddressRepository;
import com.clinic.dentum.repository.PacientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AddressService {
    private static final Logger logger = LogManager.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PacientRepository pacientRepository;

    @Autowired
    private ObjectMapper mapper;

    public Pacient registerAddress(AddressRequestDto addressDto) {

        try {

            logger.info("creating address for pacient with dni [{}]", addressDto.getDni());

            Pacient currentPacient = pacientRepository.findByDni(addressDto.getDni());
            currentPacient.setAddress(mapper.convertValue(addressDto, Address.class));

            return pacientRepository.save(currentPacient);
        } catch (Exception e) {

            logger.error(e);
        }

        return null;
    }

    public AddressResponseDto getAddressByPacient(String dni) {
        try {

            logger.info("find pacient with dni [{}]", dni);
            Pacient currePacient = pacientRepository.findByDni(dni);
            return mapper.convertValue(currePacient.getAddress(), AddressResponseDto.class);

        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    public AddressResponseDto updateAddresByPacient(AddressRequestDto addressRequestDto) {

        try {

            logger.info("updating address for pacient with dni [{}]", addressRequestDto.getDni());
            Pacient currentPacient = pacientRepository.findByDni(addressRequestDto.getDni());
            Address updateAddress = currentPacient.getAddress();
            updateAddress.setLocation(addressRequestDto.getLocation());
            updateAddress.setProvincie(addressRequestDto.getProvincie());
            updateAddress.setNumber(addressRequestDto.getNumber());
            updateAddress.setStreet(addressRequestDto.getStreet());

            return mapper.convertValue(addressRepository.save(updateAddress), AddressResponseDto.class);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    public String removeAddress(String dni) {

        try {

            logger.info("find pacient with dni [{}]", dni);

            Pacient currePacient = pacientRepository.findByDni(dni);

            logger.info("deleting address at pacient with dni [{}]", dni);

            Long idAddress = currePacient.getAddress().getId();

            currePacient.setAddress(null);
            addressRepository.deleteById(idAddress);

            return "success";
        } catch (Exception e) {
            logger.info(e);
        }

        return null;
    }

}
