package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.service.HospitalService;
import com.xworkz.hospital.service.SlotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/")
@Slf4j

public class SlotController {

    @Autowired
    private SlotService slotService;


    @RequestMapping("/slot")
    public ModelAndView slot(HttpServletRequest request) {


        String fromHour = request.getParameter("fromHour");
        String fromMinute = request.getParameter("fromMinute");
        String fromAmPm = request.getParameter("fromAmPm");

        String toHour = request.getParameter("toHour");
        String toMinute = request.getParameter("toMinute");
        String toAmPm = request.getParameter("toAmPm");

        String specialisationId = request.getParameter("specialisation");


        List<SpecialisationEntity> specialisations = slotService.getAllSpecialisation();
        ModelAndView modelAndView = new ModelAndView("slot");
        modelAndView.addObject("doctors", specialisations);


        if (specialisationId == null || specialisationId.isEmpty()) {
            return modelAndView;
        }


        if (fromHour == null || fromMinute == null || toHour == null || toMinute == null
                || fromHour.isEmpty() || fromMinute.isEmpty()
                || toHour.isEmpty() || toMinute.isEmpty()) {
            modelAndView.addObject("message", "Please fill in both From Time and To Time");
            return modelAndView;
        }


        SpecialisationEntity specialisationEntity = slotService.getById(Integer.parseInt(specialisationId));

        if (specialisationEntity == null) {
            modelAndView.addObject("message", "Invalid specialisation selected");
            return modelAndView;
        }


        String fromTime = fromHour + ":" + String.format("%02d", Integer.parseInt(fromMinute)) + " " + fromAmPm;
        String toTime = toHour + ":" + String.format("%02d", Integer.parseInt(toMinute)) + " " + toAmPm;


        SlotDTO slotDTO = new SlotDTO();
        slotDTO.setSpecialisation(specialisationEntity.getSpecialisation());
        slotDTO.setFromTime(fromTime);
        slotDTO.setToTime(toTime);

        boolean result = slotService.saveSlot(slotDTO);

        if (result) {
            modelAndView.addObject("message", "Slot details saved successfully");
            modelAndView.addObject("slot", slotDTO);
        } else {
            modelAndView.addObject("message", "Failed to save the data");
        }

        return modelAndView;
    }

}
