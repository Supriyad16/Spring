package com.xworkz.forms.entity;


import javax.persistence.*;

    @Entity
    @Table(name = "passport_db")
    public class PassportEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String holderName;
        private String passportNumber;
        private String nationality;
        private String issueDate;
        private String expiryDate;

        public PassportEntity() {
        }

        public PassportEntity(String holderName, String passportNumber, String nationality, String issueDate, String expiryDate) {
            this.holderName = holderName;
            this.passportNumber = passportNumber;
            this.nationality = nationality;
            this.issueDate = issueDate;
            this.expiryDate = expiryDate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHolderName() {
            return holderName;
        }

        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }

        public String getPassportNumber() {
            return passportNumber;
        }

        public void setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }

        @Override
        public String toString() {
            return "PassportEntity{" +
                    "id=" + id +
                    ", holderName='" + holderName + '\'' +
                    ", passportNumber='" + passportNumber + '\'' +
                    ", nationality='" + nationality + '\'' +
                    ", issueDate='" + issueDate + '\'' +
                    ", expiryDate='" + expiryDate + '\'' +
                    '}';
        }
    }


