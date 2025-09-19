package com.xworkz.hospital.restcontroller;


import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.service.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class HospitalRestController {

    private static final Logger log = LoggerFactory.getLogger(HospitalRestController.class);
    @Autowired
    public HospitalService hospitalService;

    @GetMapping(value = "/userEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userEmail(@PathVariable String email) {
        log.info("Rest Controller");
        long count = hospitalService.getEmailCount(email);
        if (count == 0) {
            return "Invalid Email ";
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
