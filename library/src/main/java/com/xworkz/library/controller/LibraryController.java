package com.xworkz.library.controller;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;
import com.xworkz.library.service.LibraryService;
import com.xworkz.library.service.LibraryServiceImp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
            for (ObjectError error : allErrors) {
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
    public ModelAndView signIn(@RequestParam String name,
                               @RequestParam String password,
                               ModelAndView modelAndView,
                               HttpSession session) {

        LibraryDTO dto = libraryService.find(name, password);

        if (dto == null) {
            modelAndView.addObject("result", "notfound"); // username/password incorrect
            modelAndView.setViewName("signin");
        } else if ("Locked".equals(dto.getName())) {
            modelAndView.addObject("result", "fail"); // account locked
            modelAndView.setViewName("signin");
        } else if ("TimeOut".equals(dto.getName())) {
            modelAndView.addObject("result", "reset"); // locked, needs password reset
            modelAndView.setViewName("signin");
        } else {
            // successful login
            session.setAttribute("loginName", dto.getName());
            session.setAttribute("loginEmail", dto.getEmail());
            modelAndView.setViewName("Home");
        }

        return modelAndView;
    }



    @RequestMapping("/forgotPassword")
    private ModelAndView forgotPassword(@Valid LibraryDTO libraryDTO, BindingResult bindingResult, ModelAndView
            modelAndView) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            for (ObjectError error : objectErrors) {
                if (error.getDefaultMessage().equals("Password must be between 4 and 20 characters \n It must contain 1 Caps, 1 Small letter, 1 number, 1 special char ")) {
                    modelAndView.addObject("error", "Password must be between 4 and 20 characters \n It must contain 1 Caps, 1 Small letter, 1 number, 1 special char");
                    modelAndView.setViewName("forgotPassword");
                    return modelAndView;
                }
            }
        }
        boolean result = libraryService.forgotPassword(libraryDTO.getEmail(), libraryDTO.getPassword(), libraryDTO.getConfirmPassword());
        if (!result) {
            modelAndView.addObject("error", "Email not found");
            modelAndView.setViewName("forgotPassword");
            return modelAndView;
        }

        modelAndView.addObject("updatedPassword", "Password Changed successfully");
        modelAndView.setViewName("signin");
        return modelAndView;

    }



//        @RequestMapping("/updateProfile")
//        public ModelAndView updateProfile (@Valid LibraryDTO libraryDTO, BindingResult bindingResult, ModelAndView
//        modelAndView){
//
//            for (ObjectError error : bindingResult.getAllErrors()) {
//                System.out.println("Validation error: " + error.getDefaultMessage());
//            }
//
//            if (bindingResult.hasErrors()) {
//                modelAndView.addObject("error", "Invalid Details");
//                modelAndView.setViewName("updateProfile");
//                return modelAndView;
//            }
//
//            boolean result = libraryService.updateprofile(libraryDTO);
//
//            if (!result) {
//                modelAndView.addObject("error", "Profile update failed");
//                modelAndView.setViewName("updateProfile");
//                return modelAndView;
//            }
//
//            modelAndView.addObject("message", "Profile updated successfully");
//            modelAndView.setViewName("success");
//            return modelAndView;
//        }

    }