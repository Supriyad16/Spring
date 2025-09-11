package com.xworkz.library.service;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.dto.UpdateProfileDTO;

public interface LibraryService {

    boolean signUp(LibraryDTO libraryDTO);

    String signIn(String email, String password);

    boolean forgotPassword(String email, String password, String confirmPassword);

    int getEmailCount(String email);

    public boolean updateProfile(UpdateProfileDTO updateProfileDTO);
}