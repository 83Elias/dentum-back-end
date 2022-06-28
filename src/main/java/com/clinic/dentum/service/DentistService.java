package com.clinic.dentum.service;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.dentum.dto.DentistRequestDto;
import com.clinic.dentum.dto.DentistResponseDto;
import com.clinic.dentum.model.Dentist;
import com.clinic.dentum.repository.DentistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DentistService {
    private static final Logger logger = LogManager.getLogger(DentistService.class);

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private ObjectMapper mapper;

    public Dentist registerDentist(DentistRequestDto dentistRequestDto) {

        try {

            logger.info("creating dentist with enrollment [{}]", dentistRequestDto.getEnrollment());

            Dentist dentist = mapper.convertValue(dentistRequestDto, Dentist.class);

            return dentistRepository.save(dentist);

        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    public DentistResponseDto getDentistByEnrollment(String enrollment) {

        try {
            logger.info("find dentist with enrollment [{}]", enrollment);

            return mapper.convertValue(dentistRepository.findByEnrollment(enrollment), DentistResponseDto.class);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    public List<Dentist> getListDentist() {

        try {
            logger.info("find and get list dentist");

            return dentistRepository.findAll();
        } catch (Exception e) {
            logger.error(e);
        }
        return Collections.emptyList();
    }

    public String removeDentist(String enrollment) {

        try {
            logger.info("removing dentist with enrollment [{}]", enrollment);
            dentistRepository.deleteByEnrollment(enrollment);
            return "success";
        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    public Dentist updateDentist(DentistRequestDto dentistRequestDto) {

        try {
            Dentist newInfoDentist = mapper.convertValue(dentistRequestDto, Dentist.class);
            Dentist updateDentist = dentistRepository.findByEnrollment(newInfoDentist.getEnrollment());
            updateDentist.setName(newInfoDentist.getName());
            updateDentist.setLastname(newInfoDentist.getLastname());
            return dentistRepository.save(updateDentist);

        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

}
