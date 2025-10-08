package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public interface PatientRepository {

    boolean patientSave(PatientEntity patientEntity);

    List<UpdatedTimeSlotEntity> getTimeSlot(int id);

    UpdatedTimeSlotEntity getInterval(int id);

    List<BloodGroupEntity> getAllBloodGroup();



}




