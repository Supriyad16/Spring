package com.xworkz.library.entity;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="library_db")

@NamedQuery(name = "getByUsernameAndPassword", query = "select entity from LibraryEntity entity where entity.name =:name")
@NamedQuery(name = "getEntityByEmail" ,query = "select entity from LibraryEntity entity where entity.email =:email")
@NamedQuery(name="updateProfile", query = "update LibraryEntity le set e.name=:name, e.age=:age, e.address=:address, e.libraryId=:libraryId, e.gender=:gender, e.phoneNumber=:phoneNumber where email =:email")
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
    @Column(name = "confirm_password")
    private String confirmPassword;

    private int failedAttempts = 0;

    private boolean accountLocked = false;

}
