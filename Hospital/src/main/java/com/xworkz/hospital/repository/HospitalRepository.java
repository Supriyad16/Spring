package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;

import java.util.List;

public interface HospitalRepository {


    HospitalEntity findByEmail(String email);

    int getEmailCount(String email);

    void save(HospitalEntity entity);

    boolean doctorSave(DoctorEntity doctorEntity);

    boolean Slot(SlotEntity slotEntity);



    List<DoctorEntity> getAllDoctors();

    List<SlotEntity> getAllSlots();

    List<DoctorEntity> getAllSpecialisation();

   // boolean assignSlotToDoctor(int doctorId, int slotId);

    DoctorEntity findDoctorById(int id);

    SlotEntity findSlotById(int id);

    void updateDoctor(DoctorEntity doctorEntity);

    boolean schedule(SpecialisationEntity specialisationEntity);

    boolean specialisationSave(SpecialisationEntity specialisationEntity);

}
