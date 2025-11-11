package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.PatientEntity;
import com.xworkz.hospital.entity.UpdatedTimeSlotEntity;
import com.xworkz.hospital.repository.DoctorRepository;
import com.xworkz.hospital.repository.PatientListRepository;
import com.xworkz.hospital.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class PatientListServiceImp implements PatientListService {

    @Autowired
    PatientListRepository patientListRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Transactional
    @Override
    public List<PatientDTO> findPatientsByCriteria(String specialisation, int doctorId, int slotId) {
        log.info("Finding patients by {}, {}, {}", specialisation, doctorId, slotId);

        List<PatientEntity> entities = patientListRepository.findPatientsByCriteria(specialisation, doctorId, slotId);

        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }

        List<PatientDTO> dtos = new ArrayList<>();

        for (PatientEntity entity : entities) {
            PatientDTO dto = new PatientDTO();
            BeanUtils.copyProperties(entity, dto);

            dto.setDoctorName(entity.getDoctor().getDoctorName());
            dto.setSlot(entity.getSlotEntity().getTimeSlot());
            dtos.add(dto);
        }

        return dtos;
    }


}