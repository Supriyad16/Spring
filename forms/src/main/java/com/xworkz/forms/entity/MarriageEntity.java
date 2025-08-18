package com.xworkz.forms.entity;


import javax.persistence.*;

    @Entity
    @Table(name = "marriage_db")
    public class MarriageEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String brideName;
        private String groomName;
        private String date;
        private String location;
        private int guests;

        public MarriageEntity() {
        }

        public MarriageEntity(String brideName, String groomName, String date, String location, int guests) {
            this.brideName = brideName;
            this.groomName = groomName;
            this.date = date;
            this.location = location;
            this.guests = guests;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBrideName() {
            return brideName;
        }

        public void setBrideName(String brideName) {
            this.brideName = brideName;
        }

        public String getGroomName() {
            return groomName;
        }

        public void setGroomName(String groomName) {
            this.groomName = groomName;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getGuests() {
            return guests;
        }

        public void setGuests(int guests) {
            this.guests = guests;
        }

        @Override
        public String toString() {
            return "MarriageEntity{" +
                    "id=" + id +
                    ", brideName='" + brideName + '\'' +
                    ", groomName='" + groomName + '\'' +
                    ", date='" + date + '\'' +
                    ", location='" + location + '\'' +
                    ", guests=" + guests +
                    '}';
        }
    }


