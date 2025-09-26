package com.xworkz.hospital.controller;


import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@Slf4j

public class DoctorController {

    @Autowired
    private HospitalService hospitalService;


        @GetMapping("/check")
        public String check(Model model) {
            {
                List<SpecialisationEntity> specialisations = hospitalService.getAllSpecialisation();
                System.out.println("Doctor details are saved" + specialisations);
                model.addAttribute("slotSpecialisations", specialisations);
                return "doctor";
            }
        }


        @PostMapping("/doctor")
        public ModelAndView registerDoctor(@RequestParam("image") MultipartFile multipartFile, @Valid @ModelAttribute DoctorDTO doctorDTO, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {

            if (!multipartFile.isEmpty()) {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get("E:\\images\\" + doctorDTO.getDoctorName() + System.currentTimeMillis() + ".jpg");
                Files.write(path, bytes);
                String imageName = path.getFileName().toString();
                doctorDTO.setImagePath(imageName);
                System.out.println("Saved image as: " + imageName);
            }

            if (bindingResult.hasErrors()) {
                bindingResult.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
                modelAndView.addObject("doctor", doctorDTO);
                modelAndView.setViewName("doctor");
            } else if (multipartFile.isEmpty()) {
                modelAndView.addObject("error", "Please upload a profile image");
                modelAndView.addObject("doctor", doctorDTO);
                modelAndView.setViewName("doctor");
            } else {
                boolean saved = hospitalService.doctorSave(doctorDTO);
                if (saved) {
                    System.out.println("===================");
                    modelAndView.addObject("message", "Doctor details saved successfully!");
                    modelAndView.addObject("doctor", doctorDTO);
                    modelAndView.setViewName("doctorResult");
                } else {
                    modelAndView.addObject("error", "Failed to save doctor details. Try again.");
                    modelAndView.addObject("doctor", doctorDTO);
                    modelAndView.setViewName("doctor");
                }
            }

            List<SpecialisationEntity> specialisations = hospitalService.getAllSpecialisation();
            System.out.println("specialisations" + specialisations);
            modelAndView.addObject("slotSpecialisations", specialisations);

            return modelAndView;
        }
    }


