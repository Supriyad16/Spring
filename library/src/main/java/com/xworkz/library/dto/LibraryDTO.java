package com.xworkz.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data

import javax.validation.constraints.*;

public class LibraryDTO {


    @NotNull
    @Size(min=3, max=12, message = "Name Should Be Between 3 and 12")
    private String name;

    @NotNull
    @Min(12)
    @Max(60)
    private int age;

    @NotNull(message = "Address should be empty")
    private int lib_id;

    @NotNull(message = "gender should not be empty")
    private String gender;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]+@gmail\\.com$", message = "Invalid format")
    private String email;

    @NotNull(message = "Phone number is required")
    @Min(value = 1000000000L, message = "Phone number must be 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be 10 digits")
    private long phone;

    @NotNull(message = "Fill the Address ")
    private String address;

    @Min(value = 0, message = "booksTaken number must be 0 digits")
    @Max(value = 5, message = "booksTaken number must be 5 digits")
    private Integer booksTaken;

    @NotNull
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[^A-Za-z0-9])(?=(.*\\d){3,}).{3,15}$", message = "password should match")
    private String password;


    public LibraryDTO(String name, int age, int lib_id, String gender, String email, long phone, String address, int books_taken, String password) {
        this.name = name;
        this.age = age;
        this.lib_id = lib_id;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
       // this.books_taken = books_taken;
        this.password = password;
    }

    public LibraryDTO() {
    }

    public  Integer getBooksTaken() {
        return booksTaken;
    }

    public void setBooksTaken(@Size(min = 0, max = 5, message = "Maximum books is only 5") Integer booksTaken) {
        this.booksTaken = booksTaken;
    }

    public  String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge( int age) {
        this.age = age;
    }

    public  int getLib_id() {
        return lib_id;
    }

    public void setLib_id( int lib_id) {
        this.lib_id = lib_id;
    }

    public  String getGender() {
        return gender;
    }

    public void setGender( String gender) {
        this.gender = gender;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }



    public long getPhone() {
        return phone;
    }

    public void setPhone( long phone) {
        this.phone = phone;
    }

    public  String getAddress() {
        return address;
    }

    public void setAddress( String address) {
        this.address = address;
    }




    public  String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LibraryDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lib_id='" + lib_id + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", books_taken=" + booksTaken +
                ", password='" + password + '\'' +
                '}';
    }
}
