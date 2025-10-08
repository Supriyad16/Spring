package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.BloodGroupDTO;
import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.dto.UpdatedTimeSlotDTO;
import com.xworkz.hospital.entity.*;
import com.xworkz.hospital.repository.DoctorRepository;
import com.xworkz.hospital.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PatientServiceImp implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<BloodGroupDTO> getAllBloodGroup() {
        List<BloodGroupEntity> entities = patientRepository.getAllBloodGroup();
        log.info(entities.toString());
        List<BloodGroupDTO> dtos = new ArrayList<>();
        for (BloodGroupEntity entity : entities) {
            BloodGroupDTO bloodGroupDto = new BloodGroupDTO();
            BeanUtils.copyProperties(entity, bloodGroupDto);
            dtos.add(bloodGroupDto);
        }
        return dtos;
    }


    @Override
    public List<UpdatedTimeSlotDTO> getTimeSlot(int id) {
        List<UpdatedTimeSlotEntity> updatedTimeSlotEntities = patientRepository.getTimeSlot(id);

        List<UpdatedTimeSlotDTO> updatedTimeSlotDTOS = new ArrayList<>();
        for (UpdatedTimeSlotEntity entity : updatedTimeSlotEntities) {
            UpdatedTimeSlotDTO dto = new UpdatedTimeSlotDTO();
            BeanUtils.copyProperties(entity, dto);
            updatedTimeSlotDTOS.add(dto);
        }
        return updatedTimeSlotDTOS;
    }


    @Override
    public boolean patientSave(PatientDTO patientDTO) {
        if (patientDTO != null) {
            PatientEntity pateintEntity = new PatientEntity();
            pateintEntity.setRegistrationId(patientDTO.getRegistrationId());
            pateintEntity.setPatientName(patientDTO.getPatientName());
            pateintEntity.setAge(patientDTO.getAge());
            pateintEntity.setBloodGroup(patientDTO.getBloodGroup());
            pateintEntity.setEmail(patientDTO.getEmail());
            pateintEntity.setPhoneNumber(patientDTO.getPhoneNumber());
            pateintEntity.setAddress(patientDTO.getAddress());
            pateintEntity.setDisease(patientDTO.getDisease());
            pateintEntity.setSpecialisation(patientDTO.getSpecialisation());
            pateintEntity.setFees(patientDTO.getFees());
            pateintEntity.setDoctorName(patientDTO.getDoctorName());
            pateintEntity.setSlot(patientDTO.getSlot());

            DoctorEntity entity1 = doctorRepository.findById(patientDTO.getDoctorId());
            log.info(entity1.toString());
            if (entity1 != null) {
                pateintEntity.setDoctor(entity1);
            }

            UpdatedTimeSlotEntity entity2 = patientRepository.getInterval(patientDTO.getSlotId());
            if (entity2 != null) {
                pateintEntity.setSlotEntity(entity2);
            }
            return true;
        }

        return false;

    }
}