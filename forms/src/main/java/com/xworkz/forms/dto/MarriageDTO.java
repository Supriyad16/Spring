package com.xworkz.forms.dto;


import javax.validation.constraints.*;

    public class MarriageDTO {

        @NotNull
        @Size(min = 3, max = 30, message = "Husband's name should be between 3 and 30 characters")
        private String husbandName;

        @NotNull
        @Size(min = 3, max = 30, message = "Wife's name should be between 3 and 30 characters")
        private String wifeName;

        @NotNull
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in format YYYY-MM-DD")
        private String marriageDate;

        @NotNull
        @Size(min = 3, max = 50, message = "Place of marriage must be between 3 and 50 characters")
        private String place;

        @NotNull
        @Size(min = 3, max = 30, message = "Witness name must be between 3 and 30 characters")
        private String witness;

        public MarriageDTO() {}

        public MarriageDTO(String husbandName, String wifeName, String marriageDate, String place, String witness) {
            this.husbandName = husbandName;
            this.wifeName = wifeName;
            this.marriageDate = marriageDate;
            this.place = place;
            this.witness = witness;
        }

        public String getHusbandName() { return husbandName; }
        public void setHusbandName(String husbandName) { this.husbandName = husbandName; }

        public String getWifeName() { return wifeName; }
        public void setWifeName(String wifeName) { this.wifeName = wifeName; }

        public String getMarriageDate() { return marriageDate; }
        public void setMarriageDate(String marriageDate) { this.marriageDate = marriageDate; }

        public String getPlace() { return place; }
        public void setPlace(String place) { this.place = place; }

        public String getWitness() { return witness; }
        public void setWitness(String witness) { this.witness = witness; }

        @Override
        public String toString() {
            return "MarriageDTO{" +
                    "husbandName='" + husbandName + '\'' +
                    ", wifeName='" + wifeName + '\'' +
                    ", marriageDate='" + marriageDate + '\'' +
                    ", place='" + place + '\'' +
                    ", witness='" + witness + '\'' +
                    '}';
        }
    }


