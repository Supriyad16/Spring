//package com.xworkz.hospital.entity;
//
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString(exclude = {"updatedTimeSlotEntities", "patientEntities", "images"})
//@Entity
//
//public class PatientListEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String doctorName;
//
//    @Column(name = "patient_reg_id")
//    private String patientRegistrationId;
//
//    private String patientName;
//
//    private String gender;
//
//    private int age;
//
//    private long phoneNumber;
//
//    private String email;
//
//    private String bloodGroup;
//
//    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<UpdatedTimeSlotEntity> updatedTimeSlotEntities = new ArrayList<>();
//
//    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<PatientEntity> patientEntities =new ArrayList<>();
//
//    @OneToMany(mappedBy = "patientEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<PatientImageEntity> images = new ArrayList<>();
//
//
//}