package com.xworkz.library.controller;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;
import com.xworkz.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @RequestMapping("/library")
    public ModelAndView Form(@Valid LibraryDTO libraryDTO, BindingResult bindingResult, ModelAndView modelAndView) {

        System.out.println(libraryDTO);

        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setName(libraryDTO.getName());
        libraryEntity.setAge(libraryDTO.getAge());
        libraryEntity.setLibraryId(libraryDTO.getLib_id());
        libraryEntity.setGender(libraryDTO.getGender());
        libraryEntity.setEmail(libraryDTO.getEmail());
        libraryEntity.setPhoneNumber(libraryDTO.getPhone());
        libraryEntity.setAddress(libraryDTO.getAddress());
        libraryEntity.setNoOfBooksTaken(libraryDTO.getBooksTaken());
        libraryEntity.setPassword(libraryDTO.getPassword());

        boolean status = libraryService.save(libraryEntity);

        if(bindingResult.hasErrors()){
            modelAndView.addObject("errors",bindingResult.getAllErrors());
        }

        modelAndView.addObject("status", status);
        modelAndView.setViewName("signup");

        return modelAndView;
    }

    public ModelAndView signUp(String name,String password,ModelAndView modelAndView) {
        boolean result = libraryService.find(name, password);

        modelAndView.addObject("result", result);


        modelAndView.setViewName("signin");
        return modelAndView;


    }

}
