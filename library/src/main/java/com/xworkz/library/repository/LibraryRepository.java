package com.xworkz.library.repository;

import com.xworkz.library.entity.LibraryEntity;

public interface LibraryRepository {

    boolean signUp(LibraryEntity entity);

    LibraryEntity findByName(String name);

    void save(LibraryEntity entity);

    Boolean forgotPassword(String email, String password, String confirmPassword);

    LibraryEntity findByEmail(String email);

    void update(LibraryEntity entity);

    int getEmailCount(String email);

    public boolean updateProfile(LibraryEntity libraryEntity);

}