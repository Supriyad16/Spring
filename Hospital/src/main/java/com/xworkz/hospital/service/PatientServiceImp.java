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

import javax.transaction.Transactional;
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
    @Transactional
    public boolean patientSave(PatientDTO patientDTO) {
        if (patientDTO == null) return false;

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setRegistrationId(patientDTO.getRegistrationId());
        patientEntity.setPatientName(patientDTO.getPatientName());
        patientEntity.setAge(patientDTO.getAge());
        patientEntity.setGender(patientDTO.getGender());
        patientEntity.setBloodGroup(patientDTO.getBloodGroup());
        patientEntity.setEmail(patientDTO.getEmail());
        patientEntity.setPhoneNumber(patientDTO.getPhoneNumber());
        patientEntity.setAddress(patientDTO.getAddress());
        patientEntity.setDisease(patientDTO.getDisease());
        patientEntity.setSpecialisation(patientDTO.getSpecialisation());
        patientEntity.setFees(patientDTO.getFees());
        patientEntity.setDoctorName(patientDTO.getDoctorName());
        patientEntity.setSlot(patientDTO.getSlot());

        // Set doctor
        if (patientDTO.getDoctorId() != null) {
            DoctorEntity doctorEntity = doctorRepository.findById(patientDTO.getDoctorId());
            if (doctorEntity != null) {
                patientEntity.setDoctor(doctorEntity);
                patientEntity.setDoctorName(doctorEntity.getDoctorName());
            } else {
                log.warn("Doctor not found with ID: {}", patientDTO.getDoctorId());
            }
        }

        // Set slot
        if (patientDTO.getSlotId() != null) {
            UpdatedTimeSlotEntity slotEntity = patientRepository.getInterval(patientDTO.getSlotId());
            if (slotEntity != null) {
                patientEntity.setSlotEntity(slotEntity);
                patientEntity.setSlot(slotEntity.getTimeSlot());
            } else {
                log.warn("Slot not found with ID: {}", patientDTO.getSlotId());
            }
        }

        // Save to DB
        patientRepository.patientSave(patientEntity);
        log.info("Patient saved: {}", patientEntity);

        return true;
    }
}