package com.xworkz.hospital.controller;


import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j


public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @RequestMapping("/admin")
    public ModelAndView admin(@RequestParam String email, @RequestParam String otp) {
        ModelAndView modelAndView = new ModelAndView();

        HospitalEntity hospitalEntity = hospitalService.findByEmail(email);

        if (hospitalEntity != null && hospitalEntity.getOTP() != null && hospitalEntity.getOTP().equals(otp)) {

            modelAndView.addObject("message", " ");
            modelAndView.setViewName("dashboard");
        } else {
            modelAndView.addObject("message", "Invalid OTP, Please try again.");
            modelAndView.setViewName("admin");
        }
        return modelAndView;
    }


    @RequestMapping("/doctor")
    public ModelAndView saveDoctor(@ModelAttribute DoctorDTO doctorDTO) {
        log.info("Doctor Data received from Form: " + doctorDTO);

        boolean isSaved = hospitalService.doctorSave(doctorDTO);

        ModelAndView mv = new ModelAndView("doctorResult");

        if (isSaved) {
            mv.addObject("message", "Doctor details saved successfully!");
            mv.addObject("doctor", doctorDTO);
        } else {
            mv.addObject("message", "Failed to save doctor details. Try again.");
        }

        return mv;
    }


    @RequestMapping("/slot")
    public ModelAndView slot(HttpServletRequest request) {
        String fromHour = request.getParameter("fromHour");
        String fromMinute = request.getParameter("fromMinute");
        String fromAmPm = request.getParameter("fromAmPm");

        String toHour = request.getParameter("toHour");
        String toMinute = request.getParameter("toMinute");
        String toAmPm = request.getParameter("toAmPm");


        String fromTime = fromHour + ":" + String.format("%02d", Integer.parseInt(fromMinute)) + " " + fromAmPm;
        String toTime = toHour + ":" + String.format("%02d", Integer.parseInt(toMinute)) + " " + toAmPm;

        SlotDTO slotDTO = new SlotDTO();
        slotDTO.setFromTime(fromTime);
        slotDTO.setToTime(toTime);

        boolean result = hospitalService.slot(slotDTO);

        ModelAndView modelAndView = new ModelAndView("slot");
        if (result) {
            modelAndView.addObject("message", "Slot details saved successfully");
            modelAndView.addObject("slot", slotDTO);
        } else {
            modelAndView.addObject("message", "Failed to save the data");
        }

        return modelAndView;

    }

    @GetMapping("/addSlots")
    public ModelAndView showAddSlotsForm() {
        List<DoctorEntity> doctors = hospitalService.getAllDoctors();
        List<SlotEntity> slots = hospitalService.getAllSlots();

        ModelAndView mv = new ModelAndView("addSlots");
        mv.addObject("doctors", doctors);
        mv.addObject("slots", slots);
        return mv;
    }

    @PostMapping("/addSlots")
    public ModelAndView assignSlot(@RequestParam("doctorName") int doctorId,
                                   @RequestParam("slot") int slotId) {
        log.info("Inside assignSlot controller - doctorId: {}, slotId: {}", doctorId, slotId);

        boolean assigned = hospitalService.assignSlotToDoctor(doctorId, slotId);

        List<DoctorEntity> doctors = hospitalService.getAllDoctors();
        List<SlotEntity> slots = hospitalService.getAllSlots();

        ModelAndView mv = new ModelAndView("addSlots");
        mv.addObject("doctors", doctors);
        mv.addObject("slots", slots);

        if (assigned) {
            mv.addObject("message", "Slot assigned successfully!");
        } else {
            mv.addObject("error", "Failed to assign slot.");
        }

        return mv;
    }
}