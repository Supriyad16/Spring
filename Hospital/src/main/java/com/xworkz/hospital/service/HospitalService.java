package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.dto.SpecialsationDTO;

import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;

import java.util.List;

public interface HospitalService {

    int getEmailCount(String email);

    String generateOtp();

    void saveOtp(String email, String otp);

    void sendOtpEmail(String email, String otp);

    String validateOtp(String email, String otp);

    HospitalEntity findByEmail(String email);

//    boolean doctorSave(DoctorDTO doctorDTO);

//    boolean slot(SlotDTO slotDTO);

    List<DoctorEntity> getAllDoctors();

    List<SlotEntity> getAllSlots();

    List<SpecialisationEntity> getAllSpecialisation();

//    boolean specialisationSave(SpecialsationDTO specialsationDTO);

//    DoctorDTO findDoctorByEmail(String email);

//    SpecialisationEntity getById(int id);

//    boolean updateDoctorByEmail(String email, DoctorDTO doctorDTO);

    List<SlotEntity> getAllSlotSpecialisations(String specialisation);

    List<DoctorEntity> getUnassignedDoctors(String specialisation);

    boolean assignSlotToDoctor(String doctorName, String timeSlot);


}
