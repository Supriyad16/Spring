package com.xworkz.hospital.restcontroller;


import com.xworkz.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class HospitalRestController {

    @Autowired
    public HospitalService hospitalService;

    @GetMapping(value = "/userEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userEmail(@PathVariable String email) {
        System.out.println("Rest controller");
        long count = hospitalService.getEmailCount(email);
        if (count == 0) {
            return " ";
        } else {
            return "email already exists";
        }
    }
}
