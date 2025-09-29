package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.*;

import java.util.List;

public interface HospitalRepository {


    HospitalEntity findByEmail(String email);

    int getEmailCount(String email);

    void save(HospitalEntity entity);

    boolean doctorSave(DoctorEntity doctorEntity);

    boolean saveSlot(SlotEntity slotEntity);

    List<DoctorEntity> getAllDoctors();

    List<SlotEntity> getAllSlots();

    List<SpecialisationEntity> getAllSpecialisations();

   // boolean assignSlotToDoctor(int doctorId, int slotId);

    DoctorEntity findDoctorById(int id);

    DoctorEntity findDoctorByEmail(String email);

    SlotEntity findSlotById(int id);

    SpecialisationEntity getById(int id);

  //  SpecialisationEntity findSpecialisationById(String specialisation);

    List<SlotEntity> getAllSlotSpecialisations(String specialisation);

    boolean  updateDoctorByEmail(String email, DoctorEntity updatedDoctor);

    boolean specialisationSave(SpecialisationEntity specialisationEntity);

    List<DoctorEntity> getUnassignedDoctors(String specialisation);

    void updateDoctor(DoctorEntity doctor);

    boolean assignSlotToDoctor(int doctorId, int slotId);

    boolean deleteDoctorByEmail(String email);

   // void saveUpdatedTimeSlot(UpdatedTimeSlotEntity slotEntity);


}
