package com.xworkz.library.dto;

import lombok.*;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class LibraryDTO {


    @NotNull
    @Size(min = 3, max = 12, message = "Name Should Be Between 3 and 12")
    private String name;

    @NotNull
    @Min(12)
    @Max(60)
    private int age;

    @NotNull(message = "Library Id should not be empty")
    private int libraryId;

    @NotNull(message = "gender should not be empty")
    private String gender;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]+@gmail\\.com$", message = "Invalid format")
    private String email;

    @NotNull(message = "Phone number is required")
    @Min(value = 1000000000L, message = "Phone number must be 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be 10 digits")
    private long phoneNumber;

    @NotNull(message = "Fill the Address ")
    private String address;

    @Min(value = 0, message = "booksTaken number must be 0 digits")
    @Max(value = 5, message = "booksTaken number must be 5 digits")
    private Integer noOfBooksTaken;

    @NotNull
    @Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
    @Pattern( regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{4,20}$", message = "Invalid password")
    private String password;


    @NotNull(message = "Confirm Password cannot be empty")
    private String confirmPassword;

    private int failedAttempts;

    private boolean accountLocked;

    private String imagePath;

    public boolean isAccountLocked() {
        return this.accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }


}
