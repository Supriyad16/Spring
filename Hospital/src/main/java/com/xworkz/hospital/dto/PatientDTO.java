package com.xworkz.hospital.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString


public class PatientDTO {

    private int id;

    private String registrationId;

    private String patientName;

    private String gender;

    private int age;

    private long phoneNumber;

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
}
