package com.xworkz.hospital.controller;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.dto.SpecialsationDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.service.DoctorService;
import com.xworkz.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.*;
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

    @Autowired
    private DoctorService doctorService;


    @RequestMapping("/admin")
    public ModelAndView admin(@RequestParam String email, @RequestParam String otp) {
        ModelAndView modelAndView = new ModelAndView();

        String status = hospitalService.validateOtp(email, otp);

        if ("VALID".equals(status)) {
            modelAndView.addObject("message", "Login successful");
            modelAndView.setViewName("dashboard");
        } else if ("EXPIRED".equals(status)) {
            modelAndView.addObject("message", "OTP has expired. Please request a new one.");
            modelAndView.setViewName("admin");
        } else {
            modelAndView.addObject("message", "Invalid OTP, please try again.");
            modelAndView.setViewName("admin");
        }

        return modelAndView;
    }

    @RequestMapping("/resendOtp")
    public ModelAndView resendOtp(@RequestParam String email) {
        ModelAndView modelAndView = new ModelAndView();

        if (email == null || email.trim().isEmpty()) {
            modelAndView.addObject("message", "Email is missing. Cannot resend OTP.");
            modelAndView.setViewName("admin");
            return modelAndView;
        }

        // Generate & save new OTP
        String newOtp = hospitalService.generateOtp();
        hospitalService.saveOtp(email, newOtp);

        // Send OTP
        hospitalService.sendOtpEmail(email, newOtp);

        modelAndView.addObject("message", "A new OTP has been sent to your email.");
        modelAndView.setViewName("admin");
        return modelAndView;
    }




    @GetMapping("/DoctorList")
    public String listDoctors(Model model) {
        List<DoctorDTO> doctors = doctorService.getAllDoctors();
        System.out.println("Number of doctors fetched: " + doctors.size());
        log.info("Doctors fetched: {}", doctors);
        model.addAttribute("doctors", doctors); // must match JSP
        return "DoctorList";
    }

    @GetMapping("/UpdateDoctor")
    public ModelAndView loadUpdateDoctorForm(@RequestParam(required = false) String email) {
        ModelAndView mv = new ModelAndView("UpdateDoctor");

        DoctorDTO doctorDTO = doctorService.findDoctorByEmail(email);
        if (doctorDTO != null) {
            mv.addObject("doc", doctorDTO);
        } else {
            mv.addObject("error", "Doctor not found with email: " + email);
        }

        mv.addObject("specialisations", doctorService.getAllSpecialisation());
        return mv;
    }

    @PostMapping("/updateDoctor")
    public ModelAndView updateDoctor(
            @ModelAttribute DoctorDTO doctorDTO,
            @RequestParam(value = "image", required = false) MultipartFile imageFile) {

        ModelAndView mv = new ModelAndView("UpdateDoctor");

        boolean updated = doctorService.updateDoctor(imageFile, doctorDTO);

        if (updated) {
            mv.addObject("message", "Doctor details updated successfully!");
        } else {
            mv.addObject("error", "Failed to update doctor details. Try again.");
        }

        // Reload updated doctor and specialisations for JSP
        DoctorDTO updatedDoctor = doctorService.findDoctorByEmail(doctorDTO.getEmail());
        mv.addObject("doc", updatedDoctor);
        mv.addObject("specialisations", doctorService.getAllSpecialisation());

        return mv;
    }


    @GetMapping("download")
    public void download(HttpServletResponse response, @RequestParam String imagePath)throws IOException{
        response.setContentType("image/jpeg");
        File file=new File("E:\\images\\"+imagePath);
        if(file.exists()) {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            ServletOutputStream outputStream = response.getOutputStream();
            IOUtils.copy(inputStream, outputStream);
            response.flushBuffer();
        }
    }
}

//    @GetMapping("/disp")
//    public  String display(Model model) {
//        {
//            List<SpecialisationEntity> specialisations = hospitalService.getAllSpecialisation();
//            System.out.println("specialisations"+specialisations);
//            model.addAttribute("slotSpecialisations", specialisations);
//            return "addSlots";
//        }
//    }
//
//
//    @RequestMapping("/addSlots")
//    public ModelAndView doctorSlotPage(@RequestParam(required = false) String specialisation,Model model) {
//        ModelAndView mv = new ModelAndView("addSlots");
//        List<SpecialisationEntity> specialisations = hospitalService.getAllSpecialisation();
//        System.out.println("specialisations"+specialisations);
//        model.addAttribute("slotSpecialisations", specialisations);
//
//        System.out.println("Selected Specialisation: " + specialisation);
//
//        if (specialisation != null && !specialisation.isEmpty()) {
//            List<DoctorEntity> doctorEntities = hospitalService.getUnassignedDoctors(specialisation);
//            System.out.println("Unassigned Doctors: " + doctorEntities);
//            List<SlotEntity> slots = hospitalService.getAllSlotSpecialisations(specialisation);
//            System.out.println("Available Slots: " + slots);
//
//            if (doctorEntities.isEmpty()) {
//                mv.addObject("error",
//                        "Slots already assigned to all doctors of this specialisation or no doctors available.");
//            } else {
//                mv.addObject("specialisation", specialisation);
//                mv.addObject("doctors", doctorEntities);
//                mv.addObject("slots", slots);
//                mv.addObject("openDoctorForm", true);
//            }
//        }
//
//        return mv;
//    }
//
//
//    @PostMapping("/assignSlot")
//    public String assignSlotToDoctor(@RequestParam String doctorName, @RequestParam String timeSlot, RedirectAttributes redirectAttributes) {
//        boolean updated = hospitalService.assignSlotToDoctor(doctorName, timeSlot);
//
//        if (updated) {
//            System.out.println("Slot assigned successfully to doctor ID: " + doctorName);
//            redirectAttributes.addFlashAttribute("success", "Slot assigned successfully.");
//        } else {
//            System.out.println("Failed to assign slot to doctor ID: " + doctorName);
//            redirectAttributes.addFlashAttribute("error", "Failed to assign slot.");
//        }
//
//        return "redirect:/addSlots";
//    }
//
//}
