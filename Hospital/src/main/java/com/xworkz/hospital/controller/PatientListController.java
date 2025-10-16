package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.BloodGroupDTO;
import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.dto.SpecialsationDTO;
import com.xworkz.hospital.entity.BloodGroupEntity;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.service.DoctorService;
import com.xworkz.hospital.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@Slf4j
public class PatientListController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/patientList")
    public String getSpecialisationList(Model model) {
        List<SpecialisationEntity> specialisation = doctorService.getAllSpecialisation();
        log.info(specialisation.toString());
        model.addAttribute("slotSpecialisations", specialisation);
        return "patientList";
    }


    @PostMapping("/patientDetails")
    public ModelAndView getDoctorsDetails(@Valid PatientDTO dto, BindingResult result, ModelAndView view)  {
        view.setViewName("patient");

        // Debug: print DTO received from form
        log.info("Received PatientDTO: {}", dto);

        // Reload dropdowns
        List<SpecialisationEntity> specializationDtos = doctorService.getAllSpecialisation();
        view.addObject("slotSpecialisations", specializationDtos);


        if (result.hasErrors()) {
            List<String> errorMessages = result.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            view.addObject("validationErrors", errorMessages);
            view.addObject("dto", dto);
            log.info("Validation errors: {}", errorMessages);
        }
        return view;
    }
}