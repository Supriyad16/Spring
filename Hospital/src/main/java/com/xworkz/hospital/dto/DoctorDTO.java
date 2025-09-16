package com.xworkz.hospital.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class DoctorDTO {

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


