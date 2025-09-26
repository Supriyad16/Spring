package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.PatientEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;

import java.util.List;

public interface PatientRepository {

    boolean patientSave(PatientEntity patientEntity);

    List<SpecialisationEntity> getAllSpecialisations();

    List<DoctorEntity> getAllDoctors(String specialisation);

    List<SlotEntity> getAllSlotSpecialisation(String specialisation);

}
