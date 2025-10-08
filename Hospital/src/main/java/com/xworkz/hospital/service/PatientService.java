package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.BloodGroupDTO;
import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.dto.UpdatedTimeSlotDTO;
import com.xworkz.hospital.entity.*;

import java.util.List;

public interface PatientService {

    boolean patientSave(PatientDTO patientDTO);

    List<BloodGroupDTO> getAllBloodGroup();

    List<UpdatedTimeSlotDTO> getTimeSlot(int id);

}
