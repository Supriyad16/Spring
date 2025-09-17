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

@NamedQueries({
        @NamedQuery(name = "DoctorEntity.getAllDoctors",
                query = "SELECT d FROM DoctorEntity d"),
        @NamedQuery(name = "DoctorEntity.getById",
                query = "SELECT d FROM DoctorEntity d WHERE d.id = :id")
})

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
