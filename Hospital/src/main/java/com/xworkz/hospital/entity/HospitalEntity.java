package com.xworkz.hospital.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "hospital_data")

@NamedQuery(name = "getEmailCount", query = "select count(e) from HospitalEntity e where e.email = :email")
@NamedQuery(name = "getByEmail" ,query = "select entity from HospitalEntity entity where entity.email =:email")


public class HospitalEntity extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    @Column(name = "otp")
    private String OTP;

    @Column()
    private LocalDateTime localDateTime;

}


