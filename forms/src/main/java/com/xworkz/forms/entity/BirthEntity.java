package com.xworkz.forms.entity;


import javax.persistence.*;

    @Entity
    @Table(name = "birth_db")
    public class BirthEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String childName;
        private String fatherName;
        private String motherName;
        private String dateOfBirth;
        private String placeOfBirth;
        private String gender;

        public BirthEntity() {
        }

        public BirthEntity(String childName, String fatherName, String motherName, String dateOfBirth, String placeOfBirth, String gender) {
            this.childName = childName;
            this.fatherName = fatherName;
            this.motherName = motherName;
            this.dateOfBirth = dateOfBirth;
            this.placeOfBirth = placeOfBirth;
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getChildName() {
            return childName;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }

        public String getFatherName() {
            return fatherName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public String getMotherName() {
            return motherName;
        }

        public void setMotherName(String motherName) {
            this.motherName = motherName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getPlaceOfBirth() {
            return placeOfBirth;
        }

        public void setPlaceOfBirth(String placeOfBirth) {
            this.placeOfBirth = placeOfBirth;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "BirthEntity{" +
                    "id=" + id +
                    ", childName='" + childName + '\'' +
                    ", fatherName='" + fatherName + '\'' +
                    ", motherName='" + motherName + '\'' +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    ", placeOfBirth='" + placeOfBirth + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

}
