package com.xworkz.hospital.dto;

import lombok.*;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class PatientListDTO {

    private int id;

    private String doctorName;

    private String patientRegistrationId;

    private String patientName;

    private String gender;

    private int age;

    private long phoneNumber;

    private String email;

    private String bloodGroup;

    private String slot;

}
