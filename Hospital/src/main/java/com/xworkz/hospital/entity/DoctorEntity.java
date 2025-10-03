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
        @NamedQuery(name = "DoctorEntity.getAllDoctors", query = "SELECT d FROM DoctorEntity d"),
        @NamedQuery(name = "DoctorEntity.getById", query = "SELECT d FROM DoctorEntity d WHERE d.id = :id"),
        @NamedQuery(name = "DoctorEntity.getAllSpecialisation", query = "SELECT d FROM DoctorEntity d" ),
        @NamedQuery(name = "DoctorEntity.findDoctorByEmail", query = "SELECT d FROM DoctorEntity d WHERE d.email = :email"),
        @NamedQuery(name = "getDoctorsBySpecialisation", query = "select e from DoctorEntity e where specialisation=:specialisation")
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

    private String availableTime;

    @Column(name = "imagePath")
    private String imagePath;

//  @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private SlotEntity slotEntities = new SlotEntity();

}
