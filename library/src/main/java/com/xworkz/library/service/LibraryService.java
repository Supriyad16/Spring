package com.xworkz.library.service;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;

public interface LibraryService {

    boolean signUp(LibraryDTO libraryDTO);

    boolean signIn(String name, String password);

    boolean forgotPassword(String email, String password, String confirmPassword);

    void increaseFailedAttempts(LibraryEntity libraryEntity);

    void resetFailedAttempts(LibraryEntity libraryEntity);

    LibraryEntity findByName(String name);

    boolean updateprofile(LibraryDTO libraryDTO);
}
