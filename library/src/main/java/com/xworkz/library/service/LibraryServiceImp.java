package com.xworkz.library.service;

import com.xworkz.library.entity.LibraryEntity;
import com.xworkz.library.repository.LibraryRepository;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImp implements LibraryService{

    @Autowired

    private LibraryRepository libraryRepository;

    BasicTextEncryptor basicTextEncryptor;

    public LibraryServiceImp(){
        basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword("supd");
    }

    @Override
    public boolean save(LibraryEntity libraryEntity) {

        String password = libraryEntity.getPassword();
        String encrypt = basicTextEncryptor.encrypt(password);

        libraryEntity.setPassword(encrypt);
        System.out.println(libraryEntity);
        return libraryRepository.save(libraryEntity);
    }

    @Override
    public boolean find(String name, String password) {
        LibraryEntity libraryEntity = libraryRepository.find(name);
        String retrivePassword = libraryEntity.getPassword();
        String decrypt = basicTextEncryptor.decrypt(retrivePassword);
        System.out.println(decrypt);

        if(name.equals(libraryEntity.getName()) && password.equals(decrypt)){
            return true;
        }
       else return false;
    }
}
