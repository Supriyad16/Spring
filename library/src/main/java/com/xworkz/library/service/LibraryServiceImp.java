package com.xworkz.library.service;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;
import com.xworkz.library.repository.LibraryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Properties;

@Service
public class LibraryServiceImp implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean signUp(LibraryDTO libraryDTO) {
        LibraryEntity libraryEntity = new LibraryEntity();
        BeanUtils.copyProperties(libraryDTO, libraryEntity);

        // encrypt password
        String password = libraryEntity.getPassword();
        String encrypt = bCryptPasswordEncoder.encode(password);
        libraryEntity.setPassword(encrypt);

        sendEmail(libraryEntity.getEmail());
        libraryRepository.signUp(libraryEntity);

        return true;
    }

    @Override
    public LibraryDTO signIn(String name, String password) {

        LibraryDTO libraryDTO = new LibraryDTO();
        LocalDateTime localDateTime =LocalDateTime.now();

        LibraryEntity libraryEntity = libraryRepository.signIn(name);
        if (libraryEntity == null) {
            libraryDTO.setName("user not found");
            return libraryDTO;
        }

        else {
            if (libraryEntity.getFailedAttempts() == 3) {

                if (localDateTime.isAfter(libraryEntity.getLocalDateTime())) {
                    LibraryDTO libraryDTO1 = new LibraryDTO();
                    libraryDTO1.setName("TimeOut");
                    return libraryDTO1;
                } else {
                    LibraryDTO libraryDTO1 = new LibraryDTO();
                    libraryDTO1.setName("Locked");
                    return libraryDTO1;
                }
            } else {
                if (bCryptPasswordEncoder.matches(password, libraryEntity.getPassword())) {
                    BeanUtils.copyProperties(libraryEntity, libraryDTO);
                    libraryEntity.setFailedAttempts(0);
                    libraryEntity.setLocalDateTime(null);
                    return libraryDTO;
                } else {
                    int trial = libraryEntity.getFailedAttempts() + 1;
                    libraryEntity.setLocalDateTime(localDateTime);
                    libraryEntity.setFailedAttempts(trial);
                    if (libraryEntity.getFailedAttempts() == 3) {
                        libraryEntity.setLocalDateTime(libraryEntity.getLocalDateTime().plusMinutes(5));
                    }
                }
            }
            libraryRepository.update(libraryEntity);
            return null;
        }
    }

    @Override
    public LibraryEntity findByName(String name) {
        LibraryEntity entity = libraryRepository.findByName(name);
        if (entity == null) {
            return null;
        }
        LibraryDTO dto = new LibraryDTO();
        BeanUtils.copyProperties(entity, dto);
        return entity;
    }

    @Override
    public boolean forgotPassword(String email, String password, String confirmPassword) {
        return libraryRepository.forgotPassword(email, password, confirmPassword);
    }


//    @Override
//    public boolean updateProfile(LibraryDTO libraryDTO) {
//        // copy into entity only if repository requires entity
//        LibraryEntity libraryEntity = new LibraryEntity();
//        BeanUtils.copyProperties(libraryDTO, libraryEntity);
//        return libraryRepository.update(libraryDTO);
//    }

    private void sendEmail(String email) {
        final String username = "dinakaranctsupriya@gmail.com";
        final String password = "axct yvqw aick doac";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

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
            message.setText("Dear User,\n\nWelcome to Library!");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
