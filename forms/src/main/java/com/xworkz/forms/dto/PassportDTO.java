package com.xworkz.forms.dto;


import javax.validation.constraints.*;

    public class PassportDTO {

        @NotNull
        @Size(min = 3, max = 30, message = "Full name should be between 3 and 30 characters")
        private String fullName;

        @NotNull
        @Pattern(regexp = "^[A-Z]{1}[0-9]{7}$", message = "Passport number must start with a capital letter followed by 7 digits")
        private String passportNumber;

        @NotNull
        @Size(min = 3, max = 30, message = "Nationality should be between 3 and 30 characters")
        private String nationality;

        @NotNull(message = "Age is required")
        @Min(value = 1, message = "Minimum age is 1")
        @Max(value = 120, message = "Maximum age is 120")
        private int age;

        @NotNull(message = "Expiry year required")
        @Min(value = 2025, message = "Expiry year should be 2025 or later")
        private int expiryYear;

        public PassportDTO() {}

        public PassportDTO(String fullName, String passportNumber, String nationality, int age, int expiryYear) {
            this.fullName = fullName;
            this.passportNumber = passportNumber;
            this.nationality = nationality;
            this.age = age;
            this.expiryYear = expiryYear;
        }

        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }

        public String getPassportNumber() { return passportNumber; }
        public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

        public String getNationality() { return nationality; }
        public void setNationality(String nationality) { this.nationality = nationality; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public int getExpiryYear() { return expiryYear; }
        public void setExpiryYear(int expiryYear) { this.expiryYear = expiryYear; }

        @Override
        public String toString() {
            return "PassportDTO{" +
                    "fullName='" + fullName + '\'' +
                    ", passportNumber='" + passportNumber + '\'' +
                    ", nationality='" + nationality + '\'' +
                    ", age=" + age +
                    ", expiryYear=" + expiryYear +
                    '}';
        }
    }


