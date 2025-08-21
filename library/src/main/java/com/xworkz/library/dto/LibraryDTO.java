package com.xworkz.library.dto;

import lombok.*;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class LibraryDTO {


    @NotNull
    @Size(min = 3, max = 12, message = "Name Should Be Between 3 and 12")
    private String name;

    @NotNull
    @Min(12)
    @Max(60)
    private int age;

    @NotNull(message = "Address should be empty")
    private int libraryId;

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

    @NotNull(message = "Confirm Password cannot be empty")
    private String confirmPassword;


}
