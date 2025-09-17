package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.SlotEntity;

import java.util.List;

public interface HospitalRepository {


    HospitalEntity findByEmail(String email);

    int getEmailCount(String email);

    void save(HospitalEntity entity);

    boolean doctorSave(DoctorEntity doctorEntity);

    boolean Slot(SlotEntity slotEntity);

   // public List<SlotEntity> getAllSlots();

    List<DoctorEntity> getAllDoctors();
    List<SlotEntity> getAllSlots();
}
