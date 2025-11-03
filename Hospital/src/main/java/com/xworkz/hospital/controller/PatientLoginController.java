package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.service.DoctorService;
import com.xworkz.hospital.service.HospitalService;
import com.xworkz.hospital.service.PatientLoginService;
import com.xworkz.hospital.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@Slf4j

public class PatientLoginController {

    @Autowired
    PatientLoginService patientLoginService;

    @Autowired
    HospitalService hospitalService ;


    @RequestMapping("/patientLogin")
    public ModelAndView patientLogin(@RequestParam String email, @RequestParam String otp, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        String status = patientLoginService.validateOtp(email, otp);

        if ("VALID".equals(status)) {
            PatientDTO patient = patientLoginService.findPatientByEmail(email);
            session.setAttribute("loggedPatient", patient);
            modelAndView.addObject("patient", patient); // 👈 this is missing
            modelAndView.addObject("message", " ");
            modelAndView.setViewName("UpdatePatient");


    } else if ("EXPIRED".equals(status)) {
            modelAndView.addObject("message", "OTP has expired. Please request a new one.");
            modelAndView.setViewName("patientLogin");
        } else {
            modelAndView.addObject("message", "Invalid OTP, please try again.");
            modelAndView.setViewName("patientLogin");
        }

        return modelAndView;
    }

    @RequestMapping("/resendPatientOtp")
    public ModelAndView resendOtp(@RequestParam String email) {
        ModelAndView modelAndView = new ModelAndView();

        if (email == null || email.trim().isEmpty()) {
            modelAndView.addObject("message", "Email is missing. Cannot resend OTP.");
            modelAndView.setViewName("patientLogin");
            return modelAndView;
        }

        // Generate & save new OTP
        String newOtp = patientLoginService.generateOtp();
        patientLoginService.saveOtp(email, newOtp);

        // Send OTP
        patientLoginService.sendOtpToPatient(email, newOtp);

        modelAndView.addObject("message", "A new OTP has been sent to your email.");
        modelAndView.setViewName("patientLogin");
        return modelAndView;
    }


    @RequestMapping("/patientProfile")
    public ModelAndView showPatientProfile(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        PatientDTO patient = (PatientDTO) session.getAttribute("loggedPatient");

        if (patient == null) {
            modelAndView.setViewName("redirect:/patientLogin");
            return modelAndView;
        }

        modelAndView.addObject("patient", patient);
        modelAndView.addObject("specialisations", hospitalService.getAllSpecialisation());
        modelAndView.setViewName("updatePatient");
        return modelAndView;
    }


//    @RequestMapping("/updatePatient")
//    public ModelAndView updatePatient(@ModelAttribute PatientDTO patient, HttpSession session) {
//        ModelAndView modelAndView = new ModelAndView();
//        boolean updated = patientLoginService.updatePatientDetails(patient);
//
//        if (updated) {
//            session.setAttribute("loggedPatient", patient);
//            modelAndView.addObject("message", "Updated successfully!");
//        } else {
//            modelAndView.addObject("error", "Update failed!");
//        }
//
//        modelAndView.setViewName("updatePatient");
//        return modelAndView;
//    }


}
