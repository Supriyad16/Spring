package com.xworkz.hospital.controller;

import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j

public class AddSlotController {

    @Autowired
    HospitalService hospitalService;

    @GetMapping("/disp")
    public  String display(Model model) {
        {
            List<SpecialisationEntity> specialisations = hospitalService.getAllSpecialisation();
            System.out.println("specialisations"+specialisations);
            model.addAttribute("slotSpecialisations", specialisations);
            return "addSlots";
        }

    }


    @RequestMapping("/addSlots")
    public ModelAndView doctorSlotPage(@RequestParam(required = false) String specialisation, Model model) {
        ModelAndView mv = new ModelAndView("addSlots");
        List<SpecialisationEntity> specialisations = hospitalService.getAllSpecialisation();
        System.out.println("specialisations"+specialisations);
        model.addAttribute("slotSpecialisations", specialisations);

        System.out.println("Selected Specialisation: " + specialisation);

        if (specialisation != null && !specialisation.isEmpty()) {
            List<DoctorEntity> doctorEntities = hospitalService.getUnassignedDoctors(specialisation);
            System.out.println("Unassigned Doctors: " + doctorEntities);
            List<SlotEntity> slots = hospitalService.getAllSlotSpecialisations(specialisation);
            System.out.println("Available Slots: " + slots);

            if (doctorEntities.isEmpty()) {
                mv.addObject("error", "Slots already assigned to all doctors of this specialisation or no doctors available.");
            } else {
                mv.addObject("specialisation", specialisation);
                mv.addObject("doctors", doctorEntities);
                mv.addObject("slots", slots);
                mv.addObject("openDoctorForm", true);
            }
        }

        return mv;
    }


    @PostMapping("/assignSlot")
    public String assignSlotToDoctor(@RequestParam String doctorName, @RequestParam String timeSlot, RedirectAttributes redirectAttributes) {
        boolean updated = hospitalService.assignSlotToDoctor(doctorName, timeSlot);

        if (updated) {
            System.out.println("Slot assigned successfully to doctor ID: " + doctorName);
            redirectAttributes.addFlashAttribute("success", "Slot assigned successfully.");
        } else {
            System.out.println("Failed to assign slot to doctor ID: " + doctorName);
            redirectAttributes.addFlashAttribute("error", "Failed to assign slot.");
        }

        return "redirect:/addSlots";
    }

}


