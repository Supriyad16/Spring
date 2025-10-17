package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"updatedTimeSlotEntities", "patientEntities", "imageEntity"})

@Entity
@Table(name="doctor_data")

@NamedQueries({
        @NamedQuery(name="DoctorEntity.getAllDoctors", query="SELECT d FROM DoctorEntity d WHERE d.doctorName = :doctor"),
        @NamedQuery(name = "DoctorEntity.getById", query = "SELECT d FROM DoctorEntity d WHERE d.id = :id"),
        @NamedQuery(name = "DoctorEntity.getAllSpecialisation", query = "SELECT d FROM DoctorEntity d" ),
        @NamedQuery(name = "DoctorEntity.findDoctorByEmail", query = "SELECT d FROM DoctorEntity d WHERE d.email = :email"),
        @NamedQuery(name = "DoctorEntity.getDoctorsBySpecialisation", query = "SELECT e FROM DoctorEntity e WHERE e.specialisation = :specialisation"),
        @NamedQuery(name = "DoctorEntity.findByName", query = "SELECT d FROM DoctorEntity d WHERE d.doctorName = :doctorName"),
        @NamedQuery(name = "DoctorEntity.getDoctorsProfilePicture", query = "SELECT d, i.savedName FROM DoctorEntity d JOIN d.imageEntity i"),
        @NamedQuery(name = "DoctorEntity.getDoctorEmailCount", query = "select count(e) from DoctorEntity e where e.email = :email")

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

    @OneToOne(mappedBy = "doctor",cascade = CascadeType.ALL,orphanRemoval = true)
    private ImageEntity imageEntity;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UpdatedTimeSlotEntity> updatedTimeSlotEntities = new ArrayList<>();

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PatientEntity> patientEntities =new ArrayList<>();


}
