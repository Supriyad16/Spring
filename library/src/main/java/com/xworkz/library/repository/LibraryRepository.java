package com.xworkz.library.repository;

import com.xworkz.library.entity.LibraryEntity;

public interface LibraryRepository {

    boolean save(LibraryEntity entity);

    LibraryEntity find(String name);

}
