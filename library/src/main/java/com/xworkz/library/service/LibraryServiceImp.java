package com.xworkz.library.service;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;
import com.xworkz.library.repository.LibraryRepository;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

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
    public boolean signUp(LibraryDTO libraryDTO) {

        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setName(libraryDTO.getName());
        libraryEntity.setAge(libraryDTO.getAge());
        libraryEntity.setLibraryId(libraryDTO.getLibraryId());
        libraryEntity.setGender(libraryDTO.getGender());
        libraryEntity.setEmail(libraryDTO.getEmail());
        libraryEntity.setPhoneNumber(libraryDTO.getPhone());
        libraryEntity.setAddress(libraryDTO.getAddress());
        libraryEntity.setNoOfBooksTaken(libraryDTO.getBooksTaken());
        libraryEntity.setPassword(libraryDTO.getPassword());
        libraryEntity.setConfirmPassword(libraryDTO.getConfirmPassword());

        String password = libraryEntity.getPassword();
        String encrypt = basicTextEncryptor.encrypt(password);
        libraryEntity.setPassword(encrypt);

        sendEmail(libraryEntity.getEmail());
        libraryRepository.signUp(libraryEntity);

        return true;
    }

    @Override
    public boolean signIn(String name, String password) {
        LibraryEntity libraryEntity = libraryRepository.signIn(name);
        String retrivePassword = libraryEntity.getPassword();
        String decrypt = basicTextEncryptor.decrypt(retrivePassword);
        System.out.println(decrypt);

        if(name.equals(libraryEntity.getName()) && password.equals(decrypt)){
            return true;
        }
        return false;
    }

    @Override
    public boolean forgotPassword(String email, String password, String confirmPassword) {

        return libraryRepository.forgotPassword(email,password,confirmPassword);
    }

    @Override
    public void increaseFailedAttempts(LibraryEntity libraryEntity) {
        int newAttempts = libraryEntity.getFailedAttempts() + 1;
        libraryEntity.setFailedAttempts(newAttempts);
        if (newAttempts >= 3) {
            libraryEntity.setAccountLocked(true);
        }
        libraryRepository.lock(libraryEntity);
    }

    @Override
    public void resetFailedAttempts(LibraryEntity libraryEntity) {
            libraryEntity.setFailedAttempts(0);
            libraryRepository.lock(libraryEntity);
        }




    private void sendEmail(String email){
        final String username = "dinakaranctsupriya@gmail.com";
        final String password = "axct yvqw aick doac";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Successfully Registered");
            message.setText("Dear ,"
                    + "\n\n checking email");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public LibraryEntity findByName(String name) {
        return libraryRepository.findByName(name);
    }

    @Override
    public boolean updateprofile(LibraryDTO libraryDTO) {

        LibraryEntity libraryEntity=new LibraryEntity();
        libraryEntity.setName(libraryDTO.getName());
        libraryEntity.setAge(libraryDTO.getAge());
        libraryEntity.setAddress(libraryDTO.getAddress());
        libraryEntity.setLibraryId(libraryDTO.getLibraryId());
        libraryEntity.setGender(libraryDTO.getGender());
        libraryEntity.setPhoneNumber(libraryDTO.getPhone());

        return false;
    }
}
