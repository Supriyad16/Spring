package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.SpecialsationDTO;
import com.xworkz.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
@Slf4j
public class SpecialisationController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/specialisation")
    public ModelAndView specialisation(@ModelAttribute SpecialsationDTO specialsationDTO) {
        log.info("Specialisation Data received from Form: " + specialsationDTO);

        boolean isSaved = hospitalService.specialisationSave(specialsationDTO);

        ModelAndView mv = new ModelAndView("Specialisation");

        if (isSaved) {
            mv.addObject("message", "Specialisation details saved successfully!");
            mv.addObject("doctor", specialsationDTO);
        } else {
            mv.addObject("message", "Failed to save Specialisation details. Try again.");
        }

        return mv;
    }
}
