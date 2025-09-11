package com.xworkz.library.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="library_db")

@NamedQuery(name = "getByName", query = "select entity from LibraryEntity entity where entity.name = :name")
@NamedQuery(name = "getByEmail" ,query = "select entity from LibraryEntity entity where entity.email =:email")
@NamedQuery(name = "updateProfile", query = "UPDATE LibraryEntity le SET le.name = :name, le.age = :age, le.address = :address, " + "le.libraryId = :libraryId, le.phoneNumber = :phoneNumber " + "WHERE le.email = :email")
@NamedQuery(name = "getEmailCount", query = "select count(entity) from LibraryEntity entity where entity.email =: email")


public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(name = "lib_id")
    private int libraryId;

    private String gender;

    private String email;

    @Column(name = "phone")
    private long phoneNumber;

    private String address;

    @Column(name = "books_taken")
    private int noOfBooksTaken;

    private String password;

    @Transient
    private String confirmPassword;

    private int failedAttempts = 0;

    private boolean accountLocked;

    @Column(name = "local_dateTime")
    private LocalDateTime localDateTime;

}
