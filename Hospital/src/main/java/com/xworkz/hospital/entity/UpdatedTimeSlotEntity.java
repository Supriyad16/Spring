package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "updated_time_slot_data")

@NamedQuery(name = "UpdatedTimeSlotEntity.getTimeSlotsByTime", query = "SELECT u FROM UpdatedTimeSlotEntity u WHERE timeSlot = :timeSlot")
public class UpdatedTimeSlotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String timeSlot;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

}








