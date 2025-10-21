package com.xworkz.hospital.entity;

import com.xworkz.hospital.dto.BloodGroupDTO;
import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name = "blood_group")

@NamedQuery(name = "getAllBloodGroup",query = "select e from BloodGroupEntity e")
public class BloodGroupEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "patient_blood_group")
    private String bloodGroup;


}
