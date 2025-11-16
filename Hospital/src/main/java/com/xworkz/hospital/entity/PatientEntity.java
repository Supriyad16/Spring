package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"images", "doctor", "slotEntity"})

@Entity
@Table(name = "patient_data")

@NamedQuery(name = "PatientEntity.getByEmail", query = "select  e from PatientEntity e where e.email=:email")
@NamedQuery(name = "PatientEntity.getByRegistrationId", query = "SELECT e FROM PatientEntity e WHERE e.registrationId = :regId")
@NamedQuery(name = "PatientEntity.getAllPatients", query = "SELECT p FROM PatientEntity p " + "JOIN FETCH p.doctor " + "JOIN FETCH p.slotEntity " + "WHERE p.specialisation = :spec " + "AND p.doctor.id = :docId " + "AND p.slotEntity.id = :slotId")
@NamedQuery(name = "PatientEntity.getPatientEmailCount", query = "select count(e) from PatientEntity e where e.email = :email")

public class PatientEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "patient_reg_id")
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

    @Column(name = "doctor_fees")
    private String fees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_fk", referencedColumnName = "id", nullable = false)
    private DoctorEntity doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timeslot_fk", referencedColumnName = "id", nullable = false)
    private UpdatedTimeSlotEntity slotEntity;

    @OneToMany(mappedBy = "patientEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PatientImageEntity> images = new ArrayList<>();

    private String otp;

    private LocalDateTime localDateTime;
}