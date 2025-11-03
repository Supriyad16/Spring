package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.PatientEntity;

public interface PatientLoginService {

    int getPatientEmailCount(String email);

    PatientDTO findPatientByEmail(String email);

    String generateOtp();

    void saveOtp(String email, String otp);

    void sendOtpToPatient(String email, String otp);

    String validateOtp(String email, String otp);
}
