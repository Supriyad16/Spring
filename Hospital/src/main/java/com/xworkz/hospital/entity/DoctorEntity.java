package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name="doctor_data")

@NamedQueries({
        @NamedQuery(name = "DoctorEntity.getAllDoctors", query = "SELECT d FROM DoctorEntity d"),
        @NamedQuery(name = "DoctorEntity.getById", query = "SELECT d FROM DoctorEntity d WHERE d.id = :id"),
        @NamedQuery(name = "DoctorEntity.getAllSpecialisation", query = "SELECT d FROM DoctorEntity d" ),
        @NamedQuery(name = "DoctorEntity.findDoctorByEmail", query = "SELECT d FROM DoctorEntity d WHERE d.email = :email"),
        @NamedQuery(name = "DoctorEntity.getDoctorsBySpecialisation", query = "SELECT e FROM DoctorEntity e WHERE e.specialisation = :specialisation"),
        @NamedQuery(name = "DoctorEntity.findByName", query = "SELECT d FROM DoctorEntity d WHERE d.doctorName = :doctorName")
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


    @Column(name = "imagePath")
    private String imagePath;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UpdatedTimeSlotEntity> updatedTimeSlotEntities = new ArrayList<>();

}
