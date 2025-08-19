package com.xworkz.forms.entity;


import javax.persistence.*;

    @Entity
    @Table(name = "scholarship_db")
    public class ScholarshipEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String studentName;
        private String scholarshipName;
        private double amount;
        private String provider;
        private String year;

        public ScholarshipEntity() {
        }

        public ScholarshipEntity(String studentName, String scholarshipName, double amount, String provider, String year) {
            this.studentName = studentName;
            this.scholarshipName = scholarshipName;
            this.amount = amount;
            this.provider = provider;
            this.year = year;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getScholarshipName() {
            return scholarshipName;
        }

        public void setScholarshipName(String scholarshipName) {
            this.scholarshipName = scholarshipName;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return "ScholarshipEntity{" +
                    "id=" + id +
                    ", studentName='" + studentName + '\'' +
                    ", scholarshipName='" + scholarshipName + '\'' +
                    ", amount=" + amount +
                    ", provider='" + provider + '\'' +
                    ", year='" + year + '\'' +
                    '}';
        }
    }


