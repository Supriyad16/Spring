package com.xworkz.forms.entity;


import javax.persistence.*;

@Entity
    @Table(name = "dance_db")
    public class DanceEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        private int age;

        @Column(name = "dance_type")
        private String danceType;

        private String email;

        private double amount;

        // Custom constructor (matching DanceDTO)
        public DanceEntity(String name, int age, String danceType, String email, double amount) {
            this.name = name;
            this.age = age;
            this.danceType = danceType;
            this.email = email;
            this.amount = amount;
        }

        // Default constructor (JPA needs this)
        public DanceEntity() {
        }

        // Getters and Setters
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

        public String getDanceType() {
            return danceType;
        }

        public void setDanceType(String danceType) {
            this.danceType = danceType;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "DanceEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", danceType='" + danceType + '\'' +
                    ", email='" + email + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }


