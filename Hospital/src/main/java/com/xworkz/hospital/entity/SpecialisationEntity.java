package com.xworkz.hospital.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


@Entity
@Table(name="specialsation_data")


public class SpecialisationEntity extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "specialisation")
    private String specialisation;

}
