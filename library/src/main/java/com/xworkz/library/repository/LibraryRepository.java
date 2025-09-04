package com.xworkz.library.repository;

import com.xworkz.library.entity.LibraryEntity;

public interface LibraryRepository {

    boolean signUp(LibraryEntity entity);

    LibraryEntity findByName(String name);

    void save(LibraryEntity entity);

    Boolean forgotPassword(String email, String password, String confirmPassword);

    LibraryEntity findByEmail(String email);

    void update(LibraryEntity entity);

    // void lock(LibraryEntity entity);

    //LibraryEntity signIn(String name);

    //void update(LibraryEntity libraryEntity);

    //boolean updateprofile(LibraryEntity libraryEntity);

}