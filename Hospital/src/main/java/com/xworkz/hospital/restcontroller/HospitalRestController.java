package com.xworkz.hospital.restcontroller;


import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.service.HospitalService;
import com.xworkz.hospital.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@Slf4j

public class HospitalRestController {


    @Autowired
    public HospitalService hospitalService;


    @GetMapping(value = "/userEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userEmail(@PathVariable String email) {
        log.info("Rest Controller");
        long count = hospitalService.getEmailCount(email);
        if (count == 0) {
            return "Invalid Email";
        } else {
            return " ";
        }
    }

    @GetMapping(value = "/sendOtp/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendOtp(@PathVariable String email) {
        System.out.println("Sending OTP to: " + email);
        HospitalEntity entity = hospitalService.findByEmail(email);
        if (entity == null) {
            return "Email not found in database!";
        }

        String otp = hospitalService.generateOtp();
        hospitalService.saveOtp(email, otp);
        hospitalService.sendOtpEmail(email, otp);

        return "OTP sent successfully to " + email;
    }
}
