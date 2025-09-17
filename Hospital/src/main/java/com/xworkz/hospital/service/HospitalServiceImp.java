package com.xworkz.hospital.service;


import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.repository.HospitalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class HospitalServiceImp implements HospitalService{

    @Autowired
    private HospitalRepository hospitalRepository;


    @Override
    public int getEmailCount(String email) {

        int count = hospitalRepository.getEmailCount(email);
        System.out.println(count);
        return count;
    }

    @Override
    public String generateOtp() {
        return String.format("%06d", new Random().nextInt(999999));
    }

    @Override
    public void saveOtp(String email, String otp) {
        HospitalEntity entity = hospitalRepository.findByEmail(email);
        if (entity != null) {
            entity.setOTP(otp);
            entity.setLocalDateTime(LocalDateTime.now());
            hospitalRepository.save(entity);
        }
    }

    public void sendOtpEmail(String email, String otp) {
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
            message.setText("Dear " +email+ ",\n\nWe received your request for a OTP to use with your account \n\nYour OTP is: " + otp + "\nIt is valid for 5 minutes.\n\nDon't share it with anyone. Ignore if this is not you. \n\nRegards,\nSushrutha Chikitsalaya");

            Transport.send(message);

            System.out.println("OTP email sent successfully to " + email);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateOtp(String email, String otp) {
        HospitalEntity entity = hospitalRepository.findByEmail(email);
        if (entity == null)
            return false;

        return entity.getOTP().equals(otp)
                && entity.getLocalDateTime().plusMinutes(5).isAfter(LocalDateTime.now());
    }

    @Override
    public HospitalEntity findByEmail(String email) {
        return hospitalRepository.findByEmail(email);
    }

    @Override
    public boolean doctorSave(DoctorDTO doctorDTO) {
        DoctorEntity doctorEntity = new DoctorEntity();
        BeanUtils.copyProperties(doctorDTO,doctorEntity);
        hospitalRepository.doctorSave(doctorEntity);

        return true;
    }

    @Override
    public boolean slot(SlotDTO slotDTO) {

        SlotEntity slotEntity = new SlotEntity();
        BeanUtils.copyProperties(slotDTO, slotEntity);
        hospitalRepository.Slot(slotEntity);
        return true;
    }

    // HospitalServiceImp.java
    @Override
    public List<DoctorEntity> getAllDoctors() {
        return hospitalRepository.getAllDoctors();
    }

    @Override
    public List<SlotEntity> getAllSlots() {
        return hospitalRepository.getAllSlots();
    }

}
