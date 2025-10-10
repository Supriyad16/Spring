package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.entity.UpdatedTimeSlotEntity;

import java.util.List;

public interface DoctorRepository {

    List<SpecialisationEntity> getAllSpecialisations();

    boolean doctorSave(DoctorEntity doctorEntity);

    DoctorEntity findById(int id);

    List<DoctorEntity> getDoctorsBySpecialisation(String specialisation);

    List<DoctorEntity> getAllDoctors();

    boolean updateDoctor(DoctorEntity doctorEntity);

    DoctorEntity findDoctorByEmail(String email);

    boolean deleteDoctorByEmail(String email);

}
