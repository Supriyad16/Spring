package com.xworkz.hospital.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString


public class PatientDTO {

    private int id;

    private String patientName;

    private String gender;

    private int age;

    private String phoneNumber;

    private String email;

    private String bloodGroup;

    private String disease;

    private String specialisation;

    private String doctorName;

    private String slot;
}
