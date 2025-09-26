package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.PatientEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;

import java.util.List;

public interface PatientService {

    boolean patientSave(PatientDTO patientDTO);

    List<SpecialisationEntity> getAllSpecialisation();

    List<DoctorEntity> getAllDoctors(String specialisation);

    List<SlotEntity> getAllSlotSpecialisations(String specialisation);
}
