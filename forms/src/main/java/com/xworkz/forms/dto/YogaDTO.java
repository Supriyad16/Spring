package com.xworkz.forms.dto;

import javax.validation.constraints.*;

public class YogaDTO {


    @NotNull
    @Size(min = 3, max = 20, message = "Name should be between 3 and 20 characters")
    private String name;

    @NotNull
    @Min(value = 12, message = "Minimum age should be 12")
    @Max(value = 80, message = "Maximum age allowed is 80")
    private int age;

    @NotNull(message = "Phone number is required")
    @Min(value = 1000000000L, message = "Phone number must be 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be 10 digits")
    private long phoneNumber;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Email must be valid and end with @gmail.com")
    private String email;

    @NotNull(message = "Address cannot be empty")
    @Size(min = 5, max = 50, message = "Address should be between 5 and 50 characters")
    private String address;


        public YogaDTO() {
        }

        public YogaDTO(String name, int age, long phoneNumber, String email, String address) {
            this.name = name;
            this.age = age;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.address = address;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
        public String toString() {
            return "YogaDTO{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", phoneNumber=" + phoneNumber +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }





