package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.PatientEntity;

import java.util.List;

public interface PatientListRepository {

    List<PatientEntity> findPatientsByCriteria(String specialisation, int doctorId, int slotId);

}
