package com.clinic.dentum.service;


import java.util.Collections;
import java.util.List;

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

   private static final Logger logger = LogManager.getLogger(TurnService.class);

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

   public TurnPacientWithDentist getTurnRegistered(TurnRequestDto turnRequestDto) {

      try {

         logger.info("creating turn for pacient with dni [{}] to dentist with enrollment [{}]",
               turnRequestDto.getDniPacient(), turnRequestDto.getEnrollmentDentist());

         Pacient currentPacient = pacientRepository.findByDni(turnRequestDto.getDniPacient());
         Dentist currentDentist = dentistRepository.findByEnrollment(turnRequestDto.getEnrollmentDentist());
         TurnPacientWithDentist turnPacientWithDentist = mapper.convertValue(turnRequestDto,
               TurnPacientWithDentist.class);

         turnPacientWithDentist
               .setShiftDate(businessUtil.parseStringToLocalDateTime(turnRequestDto.getShiftDateTurn()));
         turnPacientWithDentist.setPacient(currentPacient);
         turnPacientWithDentist.setDentist(currentDentist);
         return turnRepository.save(turnPacientWithDentist);

      } catch (Exception e) {
         logger.error(e);
      }

      return null;
   }



   public  List<TurnResponseDto> findTurn(String dni, String enrollment){
       logger.info("dni {} and enrollment {}",dni,enrollment);

       if (enrollment!=null) {
         return getTurnByDentist(enrollment);
      }

      if (dni!=null) {
         return getTurnByPacient(dni);
      }

      
        
      return Collections.emptyList();
   }

   public List<TurnResponseDto> getTurnByPacient(String dni) {

      try {

         logger.info("find turn for pacient with dni [{}]", dni);
         Pacient pacient = pacientRepository.findByDni(dni);

         return turnRepository.getTurnByIdPacient(pacient.getId());
      } catch (Exception e) {
         logger.error(e);
      }

      return Collections.emptyList();
   }

   public List<TurnResponseDto> getTurnByDentist(String enrollment) {

      try {

         logger.info("find turn for dentist with dni [{}]", enrollment);
         Dentist dentist = dentistRepository.findByEnrollment(enrollment);

         return turnRepository.getTurnByIdDentist(dentist.getId());
      } catch (Exception e) {
         logger.error(e);
      }

      return Collections.emptyList();
   }

}
