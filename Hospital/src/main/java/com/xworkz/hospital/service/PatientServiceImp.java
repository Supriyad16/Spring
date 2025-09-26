package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.PatientEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.repository.HospitalRepository;
import com.xworkz.hospital.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class PatientServiceImp implements PatientService {

    @Autowired
    PatientRepository patientRepository;


    @Override
    public boolean patientSave(PatientDTO patientDTO) {
        PatientEntity patientEntity = new PatientEntity();
        BeanUtils.copyProperties(patientDTO, patientEntity);
        return patientRepository.patientSave(patientEntity);
    }

    @Override
    public List<SpecialisationEntity> getAllSpecialisation() {
           System.out.println("Specialisations fetched from DB: " + patientRepository.getAllSpecialisations());
        return patientRepository.getAllSpecialisations();
    }

    @Override
    public List<DoctorEntity> getAllDoctors(String specialisation) {
        List<DoctorEntity> doctors = patientRepository.getAllDoctors(specialisation);
        System.out.println("Doctors fetched from DB: " + doctors);
        return doctors;

    }

    @Override
    public List<SlotEntity> getAllSlotSpecialisations(String specialisation) {
        System.out.println("Slots fetched from DB: " + patientRepository.getAllSlotSpecialisation(specialisation));
        return patientRepository.getAllSlotSpecialisation(specialisation);
    }
}