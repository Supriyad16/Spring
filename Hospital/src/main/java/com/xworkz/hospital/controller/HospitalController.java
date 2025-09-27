package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.dto.SpecialsationDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

            modelAndView.addObject("message", " Login successful");
            modelAndView.setViewName("dashboard");
        } else {
            modelAndView.addObject("message", "Invalid OTP, Please try again.");
            modelAndView.setViewName("admin");
        }
        return modelAndView;
    }


//    @GetMapping("/check")
//    public  String check(Model model) {
//        {
//            List<SpecialisationEntity> specialisations = hospitalService.getAllSpecialisation();
//            System.out.println("Doctor details are saved" + specialisations);
//            model.addAttribute("slotSpecialisations", specialisations);
//            return "doctor";
//        }
//    }


//    @PostMapping("/doctor")
//    public ModelAndView registerDoctor(@RequestParam("image") MultipartFile multipartFile, @Valid @ModelAttribute DoctorDTO doctorDTO, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {
//
//        if (!multipartFile.isEmpty()) {
//            byte[] bytes = multipartFile.getBytes();
//            Path path = Paths.get("E:\\images\\" + doctorDTO.getDoctorName() + System.currentTimeMillis() + ".jpg");
//            Files.write(path, bytes);
//            String imageName = path.getFileName().toString();
//            doctorDTO.setImagePath(imageName);
//            System.out.println("Saved image as: " + imageName);
//        }
//
//        if (bindingResult.hasErrors()) {
//            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
//            modelAndView.addObject("doctor", doctorDTO);
//            modelAndView.setViewName("doctor");
//        }
//        else if (multipartFile.isEmpty()) {
//            modelAndView.addObject("error", "Please upload a profile image");
//            modelAndView.addObject("doctor", doctorDTO);
//            modelAndView.setViewName("doctor");
//        }
//        else {
//            boolean saved = hospitalService.doctorSave(doctorDTO);
//            if (saved) {
//                modelAndView.addObject("message", "Doctor details saved successfully!");
//                modelAndView.addObject("doctor", doctorDTO);
//                modelAndView.setViewName("doctorResult");
//            } else {
//                modelAndView.addObject("error", "Failed to save doctor details. Try again.");
//                modelAndView.addObject("doctor", doctorDTO);
//                modelAndView.setViewName("doctor");
//            }
//        }
//
//        List<SpecialisationEntity> specialisations = hospitalService.getAllSpecialisation();
//        System.out.println("specialisations"+specialisations);
//        modelAndView.addObject("slotSpecialisations", specialisations);
//
//        return modelAndView;
//    }
//



    @RequestMapping("/slot")
    public ModelAndView slot(HttpServletRequest request) {


        String fromHour = request.getParameter("fromHour");
        String fromMinute = request.getParameter("fromMinute");
        String fromAmPm = request.getParameter("fromAmPm");

        String toHour = request.getParameter("toHour");
        String toMinute = request.getParameter("toMinute");
        String toAmPm = request.getParameter("toAmPm");

        String specialisationId = request.getParameter("specialisation");


        List<SpecialisationEntity> specialisations = hospitalService.getAllSpecialisation();
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


        SpecialisationEntity specialisationEntity =
                hospitalService.getById(Integer.parseInt(specialisationId));


        String fromTime = fromHour + ":" + String.format("%02d", Integer.parseInt(fromMinute)) + " " + fromAmPm;
        String toTime = toHour + ":" + String.format("%02d", Integer.parseInt(toMinute)) + " " + toAmPm;


        SlotDTO slotDTO = new SlotDTO();
        slotDTO.setSpecialisation(specialisationEntity.getSpecialisation());
        slotDTO.setFromTime(fromTime);
        slotDTO.setToTime(toTime);

        boolean result = hospitalService.slot(slotDTO);

        if (result) {
            modelAndView.addObject("message", "Slot details saved successfully");
            modelAndView.addObject("slot", slotDTO);
        } else {
            modelAndView.addObject("message", "Failed to save the data");
        }

        return modelAndView;
    }

    @GetMapping("/DoctorList")
    public String listDoctors(Model model) {
        List<DoctorEntity> doctors = hospitalService.getAllDoctors();
        System.out.println("Number of doctors fetched: " + doctors.size());
        log.info("Doctors fetched: {}", doctors);
        model.addAttribute("doctors", doctors); // must match JSP
        return "DoctorList";
    }

    @GetMapping("/UpdateDoctor")
    public ModelAndView loadUpdateDoctorForm(@RequestParam(required = false) String email) {
        ModelAndView mv = new ModelAndView("UpdateDoctor");

        DoctorDTO doctorDTO = hospitalService.findDoctorByEmail(email);
        if (doctorDTO != null) {
            mv.addObject("doc", doctorDTO);
        } else {
            mv.addObject("error", "Doctor not found with email: " + email);
        }

        mv.addObject("specialisations", hospitalService.getAllSpecialisation());
        return mv;
    }

    @PostMapping("/updateDoctor")
    public ModelAndView updateDoctor(@ModelAttribute DoctorDTO doctorDTO) {
        ModelAndView mv = new ModelAndView("UpdateDoctor");

        boolean updated = hospitalService.updateDoctorByEmail(doctorDTO.getEmail(), doctorDTO);
        if (updated) {
            mv.addObject("message", "Doctor details updated successfully!");
        } else {
            mv.addObject("error", "Failed to update doctor details. Try again.");
        }

        // Reload doctor and specialisations for JSP
        DoctorDTO updatedDoctor = hospitalService.findDoctorByEmail(doctorDTO.getEmail());
        mv.addObject("doc", updatedDoctor);
        mv.addObject("specialisations", hospitalService.getAllSpecialisation());

        return mv;
    }


//    @GetMapping("/addSlots")
//    public ModelAndView loadSlotPage() {
//        ModelAndView mv = new ModelAndView("addSlots");
//        mv.addObject("slotSpecialisations", hospitalService.getAllSlotSpecialisations());
//        return mv;
//    }
//
//    @GetMapping("/getDoctorAndSlotsBySpecialisation")
//    @ResponseBody
//    public Map<String, Object> getDoctorAndSlots(@RequestParam String specialisation) {
//        Map<String, Object> response = new HashMap<>();
//
//        List<DoctorEntity> doctors = hospitalService.getUnassignedDoctors(specialisation);
//        List<Map<String, String>> doctorList = new ArrayList<>();
//        for (DoctorEntity d : doctors) {
//            Map<String, String> map = new HashMap<>();
//            map.put("id", String.valueOf(d.getId()));
//            map.put("name", d.getDoctorName());
//            doctorList.add(map);
//        }
//        response.put("doctors", doctorList);
//
//        List<SlotEntity> slots = hospitalService.getAllSlotSpecialisations();
//        List<Map<String, String>> slotList = new ArrayList<>();
//        for (SlotEntity s : slots) {
//            Map<String, String> map = new HashMap<>();
//            map.put("id", String.valueOf(s.getId()));
//            map.put("time", s.getFromTime() + " - " + s.getToTime());
//            slotList.add(map);
//        }
//        response.put("slots", slotList);
//
//        return response;
//    }
//
//    @PostMapping("/addSlots")
//    public ModelAndView assignSlot(@RequestParam("doctorId") int doctorId,
//                                   @RequestParam("slotId") int slotId,
//                                   @RequestParam("specialisation") String specialisation) {
//        boolean assigned = hospitalService.assignSlotToDoctor(doctorId, slotId);
//
//        ModelAndView mv = new ModelAndView("addSlots");
//        if (assigned) {
//            mv.addObject("message", "Slot assigned successfully!");
//        } else {
//            mv.addObject("error", "Failed to assign slot.");
//        }
//        return mv;
//    }

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
    public ModelAndView doctorSlotPage(@RequestParam(required = false) String specialisation,Model model) {
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
                mv.addObject("error",
                        "Slots already assigned to all doctors of this specialisation or no doctors available.");
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
    public String assignSlotToDoctor(@RequestParam("doctorId") int doctorId,
                                     @RequestParam("slotId") int slotId,
                                     RedirectAttributes redirectAttributes) {
        boolean updated = hospitalService.assignSlotToDoctor(doctorId, slotId);

        if (updated) {
            System.out.println("Slot assigned successfully to doctor ID: " + doctorId);
            redirectAttributes.addFlashAttribute("success", "Slot assigned successfully.");
        } else {
            System.out.println("Failed to assign slot to doctor ID: " + doctorId);
            redirectAttributes.addFlashAttribute("error", "Failed to assign slot.");
        }

        return "redirect:/addSlots";
    }

}
