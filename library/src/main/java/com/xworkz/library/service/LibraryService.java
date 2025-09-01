package com.xworkz.library.service;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;

public interface LibraryService {

    boolean signUp(LibraryDTO libraryDTO);

    LibraryDTO signIn(String name, String password);

    boolean forgotPassword(String email, String password, String confirmPassword);

    LibraryDTO find(String name, String password);

    void increaseFailedAttempts(LibraryDTO libraryDTO);

   void resetFailedAttempts(LibraryDTO libraryDTO);

    LibraryEntity findByName(String name);

  // boolean updateprofile(LibraryDTO libraryDTO);
}
