package com.xworkz.library.service;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;

public interface LibraryService {

    boolean signUp(LibraryDTO libraryDTO);

    String signIn(String email, String password);

    boolean forgotPassword(String email, String password, String confirmPassword);

    //boolean updateprofile(LibraryDTO libraryDTO);

    int getEmailCount(String email);

}