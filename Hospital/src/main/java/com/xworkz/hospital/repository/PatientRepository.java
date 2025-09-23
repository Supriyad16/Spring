package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.PatientEntity;

import java.util.List;

public interface PatientRepository {

    boolean patientSave(PatientEntity patientEntity);

}
