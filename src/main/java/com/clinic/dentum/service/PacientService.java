package com.clinic.dentum.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.dentum.dto.PacientRequestDto;
import com.clinic.dentum.dto.PacientResponseDto;
import com.clinic.dentum.model.Pacient;
import com.clinic.dentum.repository.PacientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;

@Service
public class PacientService {
    private static final Logger logger = LogManager.getLogger(PacientService.class);

    @Autowired
    private PacientRepository pacientRepository;

    @Autowired
    private ObjectMapper mapper;

    public Pacient registerPacient(PacientRequestDto pacientRequestDto) {

        try {

            logger.info("creating pacient with dni {}", pacientRequestDto.getDni());

            Pacient pacient = mapper.convertValue(pacientRequestDto, Pacient.class);
            pacientRepository.save(pacient);
            return pacient;

        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    public PacientResponseDto getPacientByDni(String dni) {

        try {
            logger.info("find pacient with dni {}", dni);
             return mapper.convertValue(pacientRepository.findByDni(dni), PacientResponseDto.class); 
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    public List<Pacient> getListPacient() {

        try {
            logger.info("find and get pacient list");
            return pacientRepository.findAll();
        } catch (Exception e) {
            logger.error(e);
        }
        return Collections.emptyList();
    }

    public String removePacient(String dni) {

        try {
            logger.info("removing pacient with dni {}", dni);
            pacientRepository.deleteByDni(dni);
            return "success";
        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    public Pacient updatePacient(PacientRequestDto pacientRequestDto) {

        try {
             Pacient infoPacient= mapper.convertValue(pacientRequestDto, Pacient.class);
             Pacient updatePacient=pacientRepository.findByDni(infoPacient.getDni());
             updatePacient.setName(pacientRequestDto.getName());
             updatePacient.setLastname(pacientRequestDto.getLastname());
             return pacientRepository.save(updatePacient);
             
        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }
}
