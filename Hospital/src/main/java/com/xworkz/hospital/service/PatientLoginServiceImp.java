package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.PatientDTO;

import com.xworkz.hospital.entity.PatientEntity;

import com.xworkz.hospital.repository.PatientLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Random;

@Slf4j
@Service
public class PatientLoginServiceImp implements PatientLoginService{

    @Autowired
    PatientLoginRepository patientLoginRepository;

    @Override
    public int getPatientEmailCount(String email) {

        int count = patientLoginRepository.getPatientEmailCount(email);
        System.out.println(count);
        return count;
    }

    @Override
    public PatientDTO findPatientByEmail(String email) {
        PatientEntity patientLoginEntity = patientLoginRepository.findPatientByEmail(email);

        if (patientLoginEntity == null) {
            return null;
        }
        PatientDTO patientDTO = new PatientDTO();
        BeanUtils.copyProperties(patientLoginEntity, patientDTO);

        return patientDTO;
    }


    @Override
    public String generateOtp() {
        return String.format("%06d", new Random().nextInt(999999));
    }

    @Override
    public void saveOtp(String email, String otp) {
        PatientEntity entity = patientLoginRepository.findPatientByEmail(email);
        if (entity != null) {
            entity.setOtp(otp);
            entity.setLocalDateTime(LocalDateTime.now());
            patientLoginRepository.save(entity);
        }
    }

    public void sendOtpToPatient(String email, String otp) {
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
            message.setSubject("Hospital Website - OTP Verification");
            message.setText("Dear " + email + ",\n\nWe received your request for a OTP to use with your account \n\nYour OTP is: " + otp + "\nIt is valid for 5 minutes.\n\nDon't share it with anyone. Ignore if this is not you. \n\nRegards,\nSushrutha Chikitsalaya");

            Transport.send(message);

            System.out.println("OTP email sent successfully to " + email);

        } catch (
                MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String validateOtp(String email, String otp) {
        PatientEntity entity = patientLoginRepository.findPatientByEmail(email);

        if (entity == null || entity.getOtp() == null) {
            return "INVALID";
        }

        if (!otp.equals(entity.getOtp())) {
            return "INVALID";
        }

        LocalDateTime otpGeneratedTime = entity.getLocalDateTime();
        if (otpGeneratedTime == null) {
            return "INVALID";
        }

        if (otpGeneratedTime.plusMinutes(2).isBefore(LocalDateTime.now())) {
            return "EXPIRED";
        }

        return "VALID";
    }
}
