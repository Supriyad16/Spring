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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@Slf4j
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/patient")
    public String goToPatientRegistration(Model model) {
        List<SpecialisationEntity> specialization = doctorService.getAllSpecialisation();
        List<BloodGroupDTO> dtos = patientService.getAllBloodGroup();

        log.info(dtos.toString());

        model.addAttribute("slotSpecialisations", specialization); // match JSP
        model.addAttribute("bloodGroupDtos", dtos);

        return "patient"; // JSP page
    }
    @PostMapping("/patient")
    public ModelAndView registerPatient(@Valid PatientDTO dto, BindingResult result, ModelAndView view) {
        view.setViewName("patient");

        // Debug: print DTO received from form
        log.info("Received PatientDTO: {}", dto);

        // Reload dropdowns
        List<SpecialisationEntity> specializationDtos = doctorService.getAllSpecialisation();
        List<BloodGroupDTO> bloodGroupDtos = patientService.getAllBloodGroup();
        view.addObject("slotSpecialisations", specializationDtos);
        view.addObject("bloodGroupDtos", bloodGroupDtos);


        if (result.hasErrors()) {
            List<String> errorMessages = result.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            view.addObject("validationErrors", errorMessages);
            view.addObject("dto", dto);
            log.info("Validation errors: {}", errorMessages);
            return view;
        }


        if (dto != null) {
            String patientNamePart = dto.getPatientName() != null
                    ? dto.getPatientName().substring(0, Math.min(2, dto.getPatientName().length()))
                    : "XX";

            String phonePart = String.valueOf(dto.getPhoneNumber());
            phonePart = phonePart.length() >= 2 ? phonePart.substring(0, 2) : phonePart;

            String specPart = dto.getSpecialisation() != null
                    ? dto.getSpecialisation().substring(0, Math.min(2, dto.getSpecialisation().length()))
                    : "XX";

            String registrationId = ("SUCHI" + patientNamePart + phonePart + specPart).toUpperCase();
            dto.setRegistrationId(registrationId);
            log.info("Generated Registration ID: {}", registrationId);

            // Debug: before saving
            log.info("Saving patient DTO to DB: {}", dto);

            // Save patient
            boolean saved = patientService.patientSave(dto);
            log.info("Save status: {}", saved);

            if (saved) {
                view.addObject("message", "Successfully saved Patient Details");
            } else {
                view.addObject("saveError", "Failed to save patient details. Please try again.");
            }
        }

        return view;
    }
}