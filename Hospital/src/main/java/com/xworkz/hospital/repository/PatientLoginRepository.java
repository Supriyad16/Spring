package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.PatientEntity;
import com.xworkz.hospital.entity.PatientLoginEntity;

public interface PatientLoginRepository {

    int getPatientEmailCount(String email);

    PatientEntity findPatientByEmail(String email);

    void save(PatientEntity entity);
}
