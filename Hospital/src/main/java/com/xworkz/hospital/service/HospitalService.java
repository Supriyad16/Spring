package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.entity.HospitalEntity;

public interface HospitalService {

    int getEmailCount(String email);

    String generateOtp();

    void saveOtp(String email, String otp);

    void sendOtpEmail(String email, String otp);

    boolean validateOtp(String email, String otp);

    HospitalEntity findByEmail(String email);

    boolean doctorSave(DoctorDTO doctorDTO);

}
