package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "patient_data")

public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
