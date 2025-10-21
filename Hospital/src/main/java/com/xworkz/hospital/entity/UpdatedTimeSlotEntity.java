package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"doctor", "pateintEntities"})

@Entity
@Table(name = "updated_time_slot_data")

@NamedQuery(name = "UpdatedTimeSlotEntity.getTimeSlotsByTime", query = "SELECT u FROM UpdatedTimeSlotEntity u WHERE timeSlot = :timeSlot")
@NamedQuery(name = "getIntervalById",query = "select e from UpdatedTimeSlotEntity e where e.id=:id")
@NamedQuery(name = "getTimeSlotId",query = "select e from UpdatedTimeSlotEntity e where e.doctor.id=:id")

public class UpdatedTimeSlotEntity extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String timeSlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    @Column(name = "doctor_name")
    private String doctorName;

    @OneToMany(mappedBy = "slotEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PatientEntity> pateintEntities=new ArrayList<>();

}
