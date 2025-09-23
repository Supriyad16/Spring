package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.entity.PatientEntity;
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
    HospitalRepository hospitalRepository;

    @Override
    public boolean patientSave(PatientDTO patientDTO) {
        PatientEntity patientEntity = new PatientEntity();
        BeanUtils.copyProperties(patientDTO, patientEntity);
        return patientRepository.patientSave(patientEntity);
    }


}
