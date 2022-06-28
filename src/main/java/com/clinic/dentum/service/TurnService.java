package com.clinic.dentum.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.dentum.dto.TurnRequestDto;
import com.clinic.dentum.dto.TurnResponseDto;
import com.clinic.dentum.model.Dentist;
import com.clinic.dentum.model.Pacient;
import com.clinic.dentum.model.TurnPacientWithDentist;
import com.clinic.dentum.repository.DentistRepository;
import com.clinic.dentum.repository.PacientRepository;
import com.clinic.dentum.repository.TurnRepository;
import com.clinic.dentum.util.BusinessUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TurnService {

    private static final Logger logger = LogManager.getLogger(DentistService.class);

    @Autowired
    private TurnRepository turnRepository;

    @Autowired 
    private PacientRepository pacientRepository;
    
    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private BusinessUtil businessUtil;

    @Autowired
    private ObjectMapper mapper;


 
    public TurnPacientWithDentist getTurnRegistered(TurnRequestDto turnRequestDto){
    
      
         try {

            logger.info("creating turn for pacient with dni [{}] to dentist with enrollment [{}]",turnRequestDto.getDniPacient(),turnRequestDto.getEnrollmentDentist());
           

            Pacient currentPacient= pacientRepository.findByDni(turnRequestDto.getDniPacient());
            Dentist currentDentist= dentistRepository.findByEnrollment(turnRequestDto.getEnrollmentDentist());
            TurnPacientWithDentist turnPacientWithDentist=mapper.convertValue(turnRequestDto, TurnPacientWithDentist.class);

            turnPacientWithDentist.setShiftDate(businessUtil.parseStringToLocalDateTime(turnRequestDto.getShiftDateTurn()));
            turnPacientWithDentist.setPacient(currentPacient);
            turnPacientWithDentist.setDentist(currentDentist);
            return turnRepository.save(turnPacientWithDentist);

              
         } catch (Exception e) {
            logger.error(e);
         }

        return null;
    }


    
}
