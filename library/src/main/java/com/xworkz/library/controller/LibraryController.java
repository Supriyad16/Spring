package com.xworkz.library.controller;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.dto.UpdateProfileDTO;
import com.xworkz.library.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Multipart;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    public LibraryController() {
        log.info("Library Controller");
    }

    @RequestMapping("/signup")
    public ModelAndView signUp(@RequestParam("image") MultipartFile multipartFile,@Valid LibraryDTO libraryDTO, BindingResult bindingResult) throws IOException {

            byte[] bytes = multipartFile.getBytes();


            Path path = Paths.get("E:\\images\\" + libraryDTO.getName() + System.currentTimeMillis() + ".jpg");

            Files.write(path, bytes);

            String imageName = path.getFileName().toString();

            libraryDTO.setImagePath(imageName);

        System.out.println("image name "+imageName);
        log.info("Library DTO: {}",libraryDTO.getImagePath());


        System.out.println(libraryDTO);
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error.getDefaultMessage());
            }

            modelAndView.addObject("errors", allErrors);
            modelAndView.addObject("value", libraryDTO);
            modelAndView.setViewName("signup");
            return modelAndView;
        }

        if (!libraryDTO.getPassword().equals(libraryDTO.getConfirmPassword())) {
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
    public ModelAndView signIn(@RequestParam String email,
                               @RequestParam String password,
                               ModelAndView modelAndView,
                               HttpSession session) {

        String result = libraryService.signIn(email, password);

        if ("Login Successful".equals(result)) {
            session.setAttribute("user", email); // save session
            modelAndView.addObject("logInSuccess", "Hello " + email + ", welcome to X-workz");
            modelAndView.setViewName("profile");
        } else {
            modelAndView.addObject("error", result);
            modelAndView.addObject("email", email);
            modelAndView.setViewName("signin");
        }

        return modelAndView;
    }


    @RequestMapping("/forgotPassword")
    private ModelAndView forgotPassword(@RequestParam String email, @RequestParam String password, @RequestParam String confirmPassword, ModelAndView
            modelAndView) {

        boolean isReset = libraryService.forgotPassword(email, password, confirmPassword);
        if (isReset) {
            modelAndView.addObject("success", "Password reset successful! Please login again.");
            modelAndView.setViewName("signin");
        } else {
            modelAndView.addObject("error", "Password reset failed! Please try again.");
            modelAndView.setViewName("forgotPassword");
        }
        return modelAndView;

    }

    @RequestMapping("/updateProfile")
    public String updateProfile( @Valid UpdateProfileDTO updateProfileDTO, HttpSession httpSession)  {


        boolean result = libraryService.updateProfile(updateProfileDTO);

        if (result) {
            // Save updated data in session
            httpSession.setAttribute("data", updateProfileDTO);
            httpSession.setAttribute("name", updateProfileDTO.getName());

            // Redirect to profile page after successful update
            return "redirect:/profile";
        } else {
            // If update fails, show error page or return to update form
            return "updateProfileForm";
        }
    }

//    @RequestMapping("/updateProfile")
//    public ModelAndView updateProfile( @ModelAttribute UpdateProfileDTO updateProfileDTO, ModelAndView modelAndView) throws IOException {
//
//
//        boolean result = libraryService.updateProfile(updateProfileDTO);
//
//        if (result) {
//            modelAndView.addObject("message", "Profile updated successfully");
//            modelAndView.setViewName("success");
//        } else {
//            modelAndView.addObject("error", "Profile update failed");
//            modelAndView.setViewName("updateProfile");
//        }
//
//        return modelAndView;
//    }

    @GetMapping("/download")
    public void download(HttpServletResponse httpServletResponse, @RequestParam String fileName) throws IOException {

        httpServletResponse.setContentType("image/jpg");
        File file  = new File("E:\\images\\"+fileName);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        IOUtils.copy(inputStream, servletOutputStream);

        httpServletResponse.flushBuffer();

    }



}