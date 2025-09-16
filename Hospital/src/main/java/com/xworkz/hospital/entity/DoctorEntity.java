package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name="doctor_data")

public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String doctorName;

    private String specialisation;

    private String qualification;

    private String experience;

    private String email;

    private long phoneNumber;

    private String gender;

    private int age;

    private String availableDays;

    private String availableTime;




}
