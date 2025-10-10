package com.xworkz.hospital.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Data
public class DoctorDTO {

        private int id;

        @NotNull
        @Size(min = 3, max = 20, message = "Name Should Be Between 3 and 20")
        private String doctorName;

        private String specialisation;

        private String qualification;

        private String experience;

        @NotNull
        @Pattern(regexp = "^[A-Za-z0-9]+@gmail\\.com$", message = "Invalid format")
        private String email;

        @NotNull(message = "Phone number is required")
        @Min(value = 1000000000L, message = "Phone number must be 10 digits")
        @Max(value = 9999999999L, message = "Phone number must be 10 digits")
        private long phoneNumber;

        @NotNull(message = "gender should not be empty")
        private String gender;

        @NotNull
        @Min(12)
        @Max(60)
        private int age;

        private String imagePath;

        // For uploading new image in update form
        private MultipartFile image;
}


