package com.xworkz.library.service;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.dto.UpdateProfileDTO;
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

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @Override
    public boolean signUp(LibraryDTO libraryDTO) {
        LibraryEntity libraryEntity = new LibraryEntity();
        BeanUtils.copyProperties(libraryDTO, libraryEntity);

        libraryEntity.setPassword(bCryptPasswordEncoder.encode(libraryDTO.getPassword()));
        sendEmail(libraryEntity.getEmail());
        libraryRepository.signUp(libraryEntity);

        return true;
    }

    private static final int MAX_FAILED_ATTEMPTS = 3;

    @Override
    public String signIn(String email, String password) {


        LibraryEntity entity = libraryRepository.findByEmail(email);

        if (entity == null) {
            return "Invalid userName";
        }
        if (entity.isAccountLocked()) {

            LocalDateTime localDateTime = entity.getLocalDateTime();
            if(localDateTime!=null){
                LocalDateTime unlockTime = localDateTime.plusMinutes(5);
                if(LocalDateTime.now().isBefore(unlockTime)){
                    return "Your account is locked. Try again after 5 minutes.";
                }
                else{
                    entity.setAccountLocked(false);
                    entity.setFailedAttempts(0);
                    entity.setLocalDateTime(null);
                    libraryRepository.update(entity);
                }
            }
        }

        if (bCryptPasswordEncoder.matches(password, entity.getPassword())) {
            entity.setFailedAttempts(0);
            libraryRepository.update(entity);
            return "Login Successful";

        } else {
            int newFails = entity.getFailedAttempts() + 1;
            entity.setFailedAttempts(newFails);

            if (newFails >= MAX_FAILED_ATTEMPTS) {
                entity.setAccountLocked(true);
                entity.setLocalDateTime(LocalDateTime.now());
                libraryRepository.update(entity);
                return "Your account is locked for 5 minutes due to 3 failed attempts.";            }

            libraryRepository.update(entity);
            return "Invalid password. Attempt " + newFails + " of " + MAX_FAILED_ATTEMPTS;
        }
    }


    @Override
    public boolean forgotPassword(String email, String password, String confirmPassword) {

        String encodedPassword = bCryptPasswordEncoder.encode(password);
        String encodedConfirm = bCryptPasswordEncoder.encode(confirmPassword);
        return libraryRepository.forgotPassword(email, encodedPassword, encodedConfirm);
    }

    @Override
    public int getEmailCount(String email) {

        int count = libraryRepository.getEmailCount(email);
        System.out.println(count);
        return count;
    }

    @Override
    public boolean updateProfile(UpdateProfileDTO updateProfileDTO) {

        LibraryEntity libraryEntity = new LibraryEntity();
        BeanUtils.copyProperties(updateProfileDTO,libraryEntity);
        return libraryRepository.updateProfile(libraryEntity);
    }


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
            message.setText("Dear User,\n \nWelcome to Library!");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}