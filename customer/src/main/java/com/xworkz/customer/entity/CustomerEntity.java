package com.xworkz.customer.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name = "customer_details")
public class CustomerEntity {

    @Id
    private int id;

    @Column(name = "cname")
    private String customerName;

    private String email;

    @Column(name = "phnumber")
    private long phoneNumber;

    private String address;

}
