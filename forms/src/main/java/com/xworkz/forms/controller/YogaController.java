package com.xworkz.forms.controller;


import com.xworkz.forms.dto.YogaDTO;
import com.xworkz.forms.entity.YogaEntity;
import com.xworkz.forms.service.YogaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

    @Controller
    @RequestMapping("/")
    public class YogaController {

        @Autowired
        private YogaService yogaService;

        @RequestMapping("/yoga")
        public ModelAndView form(@Valid YogaDTO yogaDTO, BindingResult bindingResult, ModelAndView modelAndView) {

            System.out.println(yogaDTO);


            if (bindingResult.hasErrors()) {
                modelAndView.addObject("errors", bindingResult.getAllErrors());
                modelAndView.setViewName("yoga"); // redirect back to form page
                return modelAndView;
            }

            YogaEntity yogaEntity = new YogaEntity();
            yogaEntity.setName(yogaDTO.getName());
            yogaEntity.setAge(yogaDTO.getAge());
            yogaEntity.setPhoneNumber(yogaDTO.getPhoneNumber());
            yogaEntity.setEmail(yogaDTO.getEmail());
            yogaEntity.setAddress(yogaDTO.getAddress());

            boolean status = yogaService.save(yogaEntity);


            if (status) {
                modelAndView.addObject("message", " details saved successfully!");
                modelAndView.setViewName("success");
            } else {
                modelAndView.addObject("message", "Failed to save  details.");
                modelAndView.setViewName("error");
            }

            return modelAndView;
        }
    }



