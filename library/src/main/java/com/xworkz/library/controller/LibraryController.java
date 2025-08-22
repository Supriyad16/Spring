package com.xworkz.library.controller;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;
import com.xworkz.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    public LibraryController() {
        System.out.println("No-arg const of LibraryController");
    }

    @RequestMapping("/signup")
    public ModelAndView signUp(@Valid LibraryDTO libraryDTO, BindingResult bindingResult) {
        System.out.println(libraryDTO);
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {

            System.out.println("Signup page");
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error:allErrors){
                System.out.println(error.getDefaultMessage());
            }

            modelAndView.addObject("errors", allErrors);
            modelAndView.addObject("value", libraryDTO);
            modelAndView.setViewName("error");
            return modelAndView;
        }

        if (!libraryDTO.getPassword().equals(libraryDTO.getConfirmPassword())) {

            System.out.println("confirm password");

            modelAndView.addObject("error", "Password and Confirm Password do not match");
            modelAndView.addObject("value", libraryDTO);
            modelAndView.setViewName("signup");
            return modelAndView;
        }

        boolean result = libraryService.signUp(libraryDTO);

        if (!result) {
            modelAndView.addObject("error", "User already exists with this email");
            modelAndView.addObject("value", libraryDTO);
            modelAndView.setViewName("signup");
            return modelAndView;
        }

        modelAndView.addObject("success", "Registered Successfully! Please login.");
        modelAndView.setViewName("signin");
        return modelAndView;
    }


    @RequestMapping("/signin")
    public ModelAndView signIn(@RequestParam String name, @RequestParam String password, ModelAndView modelAndView){

        if(name.isEmpty() || password.isEmpty()){
            modelAndView.addObject("error","username and password cannot be empty");
            modelAndView.setViewName("signin");
            return modelAndView;
        }

        LibraryEntity libraryEntity = libraryService.findByName(name);
        boolean result = libraryService.signIn(name, password);
        if(!result){
            System.out.println("Not matched");
            modelAndView.addObject("error", "Canot find user");
            modelAndView.setViewName("signin");
            return  modelAndView;
        }

        if (libraryEntity.isAccountLocked()) {
            modelAndView.addObject("error", "Account locked. Please reset your password.");
            modelAndView.setViewName("forgotPassword");
            return modelAndView;
        }

        if (!libraryEntity.getPassword().equals(password)) {
            libraryService.increaseFailedAttempts(libraryEntity); // increases and locks if >=3
            modelAndView.addObject("error", "Invalid password. Attempts left: " + (3 - libraryEntity.getFailedAttempts()));
            modelAndView.setViewName("signin");
            return modelAndView;
        }

        libraryService.resetFailedAttempts(libraryEntity);

        System.out.println("matched");
        modelAndView.addObject("logInSuccess", "Successfully Logged In");
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping("/forgotPassword")
    private ModelAndView forgotPassword(@Valid LibraryDTO libraryDTO, BindingResult bindingResult, ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            for (ObjectError error : objectErrors) {
                if (error.getDefaultMessage().equals("Password must be at least 4 characters ") || error.getDefaultMessage().equals("Confirm Password cannot be empty")) {
                    modelAndView.addObject("error", "Enter Password");
                    modelAndView.setViewName("forgotPassword");
                    return modelAndView;
                }
            }
        }
        boolean result = libraryService.forgotPassword(libraryDTO.getEmail(), libraryDTO.getPassword(), libraryDTO.getConfirmPassword());
        if (!result) {
            modelAndView.addObject("error", "No such email registered");
            modelAndView.setViewName("forgotPassword");
            return modelAndView;
        }

        modelAndView.addObject("updatedPassword", "Password updated successfully");
        modelAndView.setViewName("index");
        return modelAndView;

    }

    public ModelAndView updateProfile(@Valid LibraryDTO libraryDTO, BindingResult bindingResult, ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", "Please correct the errors in the form");
            modelAndView.setViewName("updateProfile");
            return modelAndView;
        }

        boolean result = libraryService.updateprofile(libraryDTO);

        if (!result) {
            modelAndView.addObject("error", "Profile update failed");
            modelAndView.setViewName("updateProfile");
            return modelAndView;
        }

        modelAndView.addObject("message", "Profile updated successfully");
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
