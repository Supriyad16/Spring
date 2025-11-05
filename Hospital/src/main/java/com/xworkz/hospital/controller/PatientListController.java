package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.entity.PatientEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.service.DoctorService;
import com.xworkz.hospital.service.PatientListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class PatientListController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientListService patientListService;


    @GetMapping("/patientList")
    public String getSpecialisationList(Model model) {
        List<SpecialisationEntity> specialisation = doctorService.getAllSpecialisation();
        model.addAttribute("slotSpecialisations", specialisation);
        return "patientList";  // JSP with dropdowns
    }


    @PostMapping("/patientDetails")
    public ModelAndView getPatientDetails(@RequestParam("specialisation") String specialisation,
                                          @RequestParam("doctorId") int doctorId,
                                          @RequestParam("slotId") int slotId,
                                          ModelAndView view) {

        view.setViewName("patientListDisplay");

        log.info("Fetching patients for Specialisation: {}, Doctor ID: {}, Slot ID: {}", specialisation, doctorId, slotId);

        List<PatientDTO> patientList = patientListService.findPatientsByCriteria(specialisation, doctorId, slotId);
        System.err.println("*-*-* List od patients *-*-*"+patientList);

        if (patientList == null || patientList.isEmpty()) {
            log.warn("No patients found for given filters.");
            view.addObject("message", "No patients found for the selected criteria.");
        } else {
            log.info("Found {} patients", patientList.size());
        }

        view.addObject("patientList", patientList);
        return view;

    }
}