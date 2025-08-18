package com.xworkz.forms.dto;


import javax.validation.constraints.*;

    public class BirthDTO {

        @NotNull
        @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
        private String childName;

        @NotNull
        @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
        private String gender;

        @NotNull
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in format YYYY-MM-DD")
        private String birthDate;

        @NotNull
        @Size(min = 3, max = 50, message = "Place of birth must be between 3 and 50 characters")
        private String birthPlace;

        @NotNull
        @Size(min = 3, max = 30, message = "Mother's name should be between 3 and 30 characters")
        private String motherName;

        public BirthDTO() {}

        public BirthDTO(String childName, String gender, String birthDate, String birthPlace, String motherName) {
            this.childName = childName;
            this.gender = gender;
            this.birthDate = birthDate;
            this.birthPlace = birthPlace;
            this.motherName = motherName;
        }

        public String getChildName() { return childName; }
        public void setChildName(String childName) { this.childName = childName; }

        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }

        public String getBirthDate() { return birthDate; }
        public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

        public String getBirthPlace() { return birthPlace; }
        public void setBirthPlace(String birthPlace) { this.birthPlace = birthPlace; }

        public String getMotherName() { return motherName; }
        public void setMotherName(String motherName) { this.motherName = motherName; }

        @Override
        public String toString() {
            return "BirthDTO{" +
                    "childName='" + childName + '\'' +
                    ", gender='" + gender + '\'' +
                    ", birthDate='" + birthDate + '\'' +
                    ", birthPlace='" + birthPlace + '\'' +
                    ", motherName='" + motherName + '\'' +
                    '}';
        }
    }


