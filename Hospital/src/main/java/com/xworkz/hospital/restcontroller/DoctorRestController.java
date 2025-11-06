package com.xworkz.hospital.restcontroller;

import com.xworkz.hospital.service.DoctorService;
import com.xworkz.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j

public class DoctorRestController {

    @Autowired
    public DoctorService doctorService;


    @GetMapping(value = "/doctorEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userDoctorEmail(@PathVariable String email) {
        log.info("Rest Controller");
        long count = doctorService.getDoctorEmailCount(email);
        if (count == 1) {
            return "Email already exists";
        } else {
            return " ";

        }
    }
}
