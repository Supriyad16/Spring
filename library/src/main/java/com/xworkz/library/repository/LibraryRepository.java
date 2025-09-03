package com.xworkz.library.repository;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;

public interface LibraryRepository {

    boolean signUp(LibraryEntity entity);

    LibraryEntity signIn(String name);

    Boolean forgotPassword(String email, String password, String confirmPassword);

   // void lock(LibraryEntity entity);

    LibraryEntity findByName(String name);

    void update(LibraryEntity libraryEntity);


    //boolean updateprofile(LibraryEntity libraryEntity);


}