package com.xworkz.library.dto;

import lombok.*;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class UpdateProfileDTO {

    @NotNull
    @Size(min = 3, max = 12, message = "Name Should Be Between 3 and 12")
    private String name;

    @NotNull
    @Min(12)
    @Max(60)
    private int age;

    @NotNull(message = "Library Id should not be empty")
    private int libraryId;

    @NotNull(message = "Phone number is required")
    @Min(value = 1000000000L, message = "Phone number must be 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be 10 digits")
    private long phoneNumber;

    @NotNull(message = "Fill the Address ")
    private String address;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]+@gmail\\.com$", message = "Invalid format")
    private String email;
}
