package com.xworkz.hospital.controller;


import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.service.DoctorService;
import com.xworkz.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;

import java.util.List;


@Controller
@RequestMapping("/")
@Slf4j

public class DoctorController {

    @Autowired
    private DoctorService doctorService;


        @GetMapping("/check")
        public String check(Model model) {
            {
                List<SpecialisationEntity> specialisations = doctorService.getAllSpecialisation();
                System.out.println("Doctor details are saved" + specialisations);
                model.addAttribute("slotSpecialisations", specialisations);
                return "doctor";
            }
        }


    @PostMapping("/doctor")
    public ModelAndView registerDoctor(@RequestParam("image") MultipartFile multipartFile,
                                       @Valid @ModelAttribute("doctor") DoctorDTO doctorDTO,
                                       BindingResult bindingResult,
                                       ModelAndView modelAndView) throws IOException {

        // Validate image
        if (multipartFile.isEmpty()) {
            modelAndView.addObject("error", "Please upload a profile image");
            modelAndView.addObject("doctor", doctorDTO);
            modelAndView.setViewName("doctor");
            return modelAndView;
        }

        // Validate form fields
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error ->
                    System.out.println(error.getDefaultMessage()));
            modelAndView.addObject("doctor", doctorDTO);
            modelAndView.setViewName("doctor");
        } else {
            boolean saved = doctorService.doctorSave(multipartFile, doctorDTO);
            if (saved) {
                modelAndView.addObject("message", "Doctor details saved successfully!");
                modelAndView.addObject("doctor", doctorDTO);
                modelAndView.setViewName("doctorResult");
            } else {
                modelAndView.addObject("error", "Failed to save doctor details. Try again.");
                modelAndView.addObject("doctor", doctorDTO);
                modelAndView.setViewName("doctor");
            }
        }


        List<SpecialisationEntity> specialisations = doctorService.getAllSpecialisation();
        modelAndView.addObject("slotSpecialisations", specialisations);

        return modelAndView;
    }


    @GetMapping("/form")
    public ModelAndView doctorForm(ModelAndView modelAndView) {
        modelAndView.addObject("doctor", new DoctorDTO());
        List<SpecialisationEntity> specialisations = doctorService.getAllSpecialisation();
        modelAndView.addObject("slotSpecialisations", specialisations);
        modelAndView.setViewName("doctor");
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteDoctorByEmail(@RequestParam("email") String email, Model model) {
        log.info("Deleting doctor with email: {}", email);

        boolean deleted = doctorService.deleteDoctorByEmail(email);

        if (deleted) {
            model.addAttribute("message", "Doctor with email " + email + " deleted successfully.");
        } else {
            model.addAttribute("error", "Doctor with email " + email + " not found or could not be deleted.");
        }


        return "redirect:/check";
    }
}


