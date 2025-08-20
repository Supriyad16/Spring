package com.xworkz.library.service;

import com.xworkz.library.entity.LibraryEntity;

public interface LibraryService {

    boolean save(LibraryEntity libraryEntity);

    boolean find(String name, String password);
}
