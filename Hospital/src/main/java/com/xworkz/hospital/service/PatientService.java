package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.entity.PatientEntity;

import java.util.List;

public interface PatientService {

    boolean patientSave(PatientDTO patientDTO);

}
