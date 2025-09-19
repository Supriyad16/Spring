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
public class SlotEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fromTime;

    private String toTime;



}
