package com.xworkz.hospital.controller;


import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@Slf4j


public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @RequestMapping("/admin")
    public ModelAndView admin(@RequestParam String email, @RequestParam String otp){
        ModelAndView modelAndView = new ModelAndView();

        HospitalEntity hospitalEntity = hospitalService.findByEmail(email);

        if(hospitalEntity!= null && hospitalEntity.getOTP() != null && hospitalEntity.getOTP().equals(otp)){

            modelAndView.addObject("message", "Login Successful");
            modelAndView.setViewName("dashboard");
        }

        else{
            modelAndView.addObject("message", "Invalid OTP, Please try again.");
            modelAndView.setViewName("admin");
        }
        return modelAndView;
    }


}
