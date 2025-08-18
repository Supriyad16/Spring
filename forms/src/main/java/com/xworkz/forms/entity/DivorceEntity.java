package com.xworkz.forms.entity;


import javax.persistence.*;

    @Entity
    @Table(name = "divorce_db")
    public class DivorceEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String husbandName;
        private String wifeName;
        private String dateOfDivorce;
        private String reason;
        private String courtName;


        public DivorceEntity() {
        }


        public DivorceEntity(String husbandName, String wifeName, String dateOfDivorce, String reason, String courtName) {
            this.husbandName = husbandName;
            this.wifeName = wifeName;
            this.dateOfDivorce = dateOfDivorce;
            this.reason = reason;
            this.courtName = courtName;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHusbandName() {
            return husbandName;
        }

        public void setHusbandName(String husbandName) {
            this.husbandName = husbandName;
        }

        public String getWifeName() {
            return wifeName;
        }

        public void setWifeName(String wifeName) {
            this.wifeName = wifeName;
        }

        public String getDateOfDivorce() {
            return dateOfDivorce;
        }

        public void setDateOfDivorce(String dateOfDivorce) {
            this.dateOfDivorce = dateOfDivorce;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getCourtName() {
            return courtName;
        }

        public void setCourtName(String courtName) {
            this.courtName = courtName;
        }


        @Override
        public String toString() {
            return "DivorceEntity{" +
                    "id=" + id +
                    ", husbandName='" + husbandName + '\'' +
                    ", wifeName='" + wifeName + '\'' +
                    ", dateOfDivorce='" + dateOfDivorce + '\'' +
                    ", reason='" + reason + '\'' +
                    ", courtName='" + courtName + '\'' +
                    '}';
        }
    }


