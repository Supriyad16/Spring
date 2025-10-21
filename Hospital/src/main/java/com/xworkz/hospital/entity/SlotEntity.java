package com.xworkz.hospital.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
@NamedQuery(
        name = "checkDuplicates",
        query = "SELECT s FROM SlotEntity s WHERE s.specialisation = :spec AND s.fromTime = :fromTime AND s.toTime = :toTime")


public class SlotEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String specialisation;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String fromTime;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String toTime;

}
