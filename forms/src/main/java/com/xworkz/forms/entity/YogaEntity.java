package com.xworkz.forms.entity;

import lombok.*;
import javax.persistence.*;



    @Entity
    @Table(name = "yoga_db")
    public class YogaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        private int age;

        @Column(name = "phone_number")
        private long phoneNumber;

        private String email;

        private String address;

        // Custom constructor (as per your YogaDTO)
        public YogaEntity(String name, int age, long phoneNumber, String email, String address) {
            this.name = name;
            this.age = age;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.address = address;
        }



        // Getters and Setters (redundant since Lombok does it, but adding for clarity)
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public long getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }


