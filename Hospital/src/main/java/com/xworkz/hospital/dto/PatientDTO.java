package com.xworkz.hospital.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString


public class PatientDTO {

    private int id;

    private String registrationId;

    @NotNull
    @Size(min = 3, max = 20, message = "Name Should Be Between 3 and 20")
    private String patientName;

    @NotNull(message = "gender should not be empty")
    private String gender;

    @NotNull
    @Min(1)
    @Max(90)
    private int age;

    @NotNull(message = "Phone number is required")
    @Min(value = 1000000000L, message = "Phone number must be 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be 10 digits")
    private long phoneNumber;

    @Pattern(regexp = "^[A-Za-z0-9]+@gmail\\.com$", message = "Invalid format")
    private String email;

    private String address;

    private String bloodGroup;

    private String disease;

    private String specialisation;

    private String doctorName;

    private String slot;

    private String fees;

    private Integer slotId;

    private Integer doctorId;

    private String otp;

    private LocalDateTime localDateTime;

}
