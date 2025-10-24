package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.PatientEntity;

import java.util.List;

public interface PatientListService {

     List<PatientDTO> findPatientsByCriteria(String specialisation, int doctorId, int slotId);

}
