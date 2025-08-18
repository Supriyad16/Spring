package com.xworkz.forms.dto;

import javax.validation.constraints.*;

public class DanceDTO {

        @NotNull
        @Size(min = 3, max = 20, message = "Name should be between 3 and 20 characters")
        private String name;

        @NotNull
        @Min(value = 5, message = "Minimum age should be 5")
        @Max(value = 60, message = "Maximum age allowed is 60")
        private int age;

        @NotNull(message = "Dance type is required")
        @Size(min = 3, max = 30, message = "Dance type should be between 3 and 30 characters")
        private String danceType;

        @NotNull
        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Email must be valid and end with @gmail.com")
        private String email;

        @NotNull
        @Min(value = 100, message = "Minimum amount should be 100")
        @Max(value = 10000, message = "Maximum amount allowed is 10000")
        private double amount;

        public DanceDTO() {
        }

        public DanceDTO(String name, int age, String danceType, String email, double amount) {
            this.name = name;
            this.age = age;
            this.danceType = danceType;
            this.email = email;
            this.amount = amount;
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
            return "DanceDTO{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", danceType='" + danceType + '\'' +
                    ", email='" + email + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }


