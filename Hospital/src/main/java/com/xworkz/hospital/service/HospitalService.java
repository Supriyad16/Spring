package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.SlotEntity;

import java.util.List;

public interface HospitalService {

    int getEmailCount(String email);

    String generateOtp();

    void saveOtp(String email, String otp);

    void sendOtpEmail(String email, String otp);

    boolean validateOtp(String email, String otp);

    HospitalEntity findByEmail(String email);

    boolean doctorSave(DoctorDTO doctorDTO);

    boolean slot(SlotDTO slotDTO);

   // public List<SlotDTO> getAllSlots();

    List<DoctorEntity> getAllDoctors();

    List<SlotEntity> getAllSlots();

    boolean assignSlotToDoctor(int doctorId, int slotId);

    boolean schedule(DoctorDTO doctorDTO);

    boolean assignSchedule(int doctorId);
}
