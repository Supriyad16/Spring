package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@Slf4j
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("/Patient")
    public String showPatientPage(Model model) {
        model.addAttribute("patient", new PatientDTO());
        List<SpecialisationEntity> specialisations = patientService.getAllSpecialisation();
        model.addAttribute("slotSpecialisations", specialisations);
        return "Patient"; // JSP page name
    }

    @PostMapping("/Patient")
    public String registerPatient(@Valid @ModelAttribute("patient") PatientDTO patientDTO,
                                  BindingResult bindingResult,
                                  ModelAndView mv) {

        if (bindingResult.hasErrors()) {
            return "Patient";
        }

        boolean saved = patientService.patientSave(patientDTO);

        if (saved) {
            mv.addObject("success", "Patient details saved successfully!");
        } else {
            mv.addObject("error", "Failed to save Patient details.");
        }

        return "redirect:/Patient";
    }


}
