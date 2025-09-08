package com.xworkz.hospital.entity;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "hospital_db")

@NamedQuery(name = "getEmailCount", query = "select count(e) from HospitalEntity e where e.email = :email")

public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    @Column(name = "otp")
    private String OTP;

}
