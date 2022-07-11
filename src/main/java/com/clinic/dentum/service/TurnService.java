package com.clinic.dentum.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.dentum.dto.TurnRequestDto;
import com.clinic.dentum.dto.TurnResponseDto;
import com.clinic.dentum.dto.UpdateTurnDto;
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

         Pacient pacient = pacientRepository.findByDni(turnRequestDto.getDniPacient());
         Dentist dentist = dentistRepository.findByEnrollment(turnRequestDto.getEnrollmentDentist());

         TurnPacientWithDentist turnPacientWithDentist = mapper.convertValue(turnRequestDto,
               TurnPacientWithDentist.class);

         turnPacientWithDentist
               .setShiftDate(businessUtil.parseStringToLocalDateTime(turnRequestDto.getShiftDateTurn()));

         turnPacientWithDentist.setPacient(pacient);
         turnPacientWithDentist.setDentist(dentist);
         return turnRepository.save(turnPacientWithDentist);

      } catch (Exception e) {
         logger.error(e);
      }

      return null;
   }

   public TurnResponseDto findTurn(Long id) {

      try {

         return turnRepository.findTurnById(id);
      } catch (Exception e) {
         logger.error(e);
      }

      return null;
   }

   public TurnPacientWithDentist updateTurn(UpdateTurnDto updateTurnDto) {

      try {

         logger.info("update turn with id {}",updateTurnDto.getId());

         Pacient pacient = pacientRepository.findByDni(updateTurnDto.getDniPacient());
         Dentist dentist = dentistRepository.findByEnrollment(updateTurnDto.getEnrollmentDentist());

         TurnPacientWithDentist turnPacientWithDentist = mapper.convertValue(updateTurnDto,
               TurnPacientWithDentist.class);

         turnPacientWithDentist
               .setShiftDate(businessUtil.parseStringToLocalDateTime(updateTurnDto.getShiftDateTurn()));

         turnPacientWithDentist.setId(updateTurnDto.getId());
         turnPacientWithDentist.setPacient(pacient);
         turnPacientWithDentist.setDentist(dentist);
         return turnRepository.save(turnPacientWithDentist);

      } catch (Exception e) {
         logger.error(e);
      }

      return null;

   }

   public String deleteTurn(Long id) {

      try {
         turnRepository.deleteById(id);
         return "success";
      } catch (Exception e) {
         logger.error(e);
      }

      return null;
   }

}
