package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "slot_data")

@NamedQuery(name = "getAllSlots", query = "SELECT s FROM SlotEntity s")
@NamedQuery(name="getAllSlotSpecialisations", query = "SELECT s FROM SlotEntity s WHERE s.specialisation = :specialisation")
public class SlotEntity extends AuditEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String specialisation;

    private String fromTime;

    private String toTime;



}
