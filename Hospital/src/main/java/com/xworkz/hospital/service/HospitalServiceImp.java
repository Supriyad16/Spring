package com.xworkz.hospital.service;


import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.dto.SpecialsationDTO;

import com.xworkz.hospital.entity.*;
import com.xworkz.hospital.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class HospitalServiceImp implements HospitalService {

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
            message.setText("Dear " + email + ",\n\nWe received your request for a OTP to use with your account \n\nYour OTP is: " + otp + "\nIt is valid for 5 minutes.\n\nDon't share it with anyone. Ignore if this is not you. \n\nRegards,\nSushrutha Chikitsalaya");

            Transport.send(message);

            System.out.println("OTP email sent successfully to " + email);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String validateOtp(String email, String otp) {
        HospitalEntity entity = hospitalRepository.findByEmail(email);

        if (entity == null || entity.getOTP() == null) {
            return "INVALID";
        }

        if (!otp.equals(entity.getOTP())) {
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


    @Override
    public HospitalEntity findByEmail(String email) {
        return hospitalRepository.findByEmail(email);
    }

//    @Override
//    public boolean doctorSave(DoctorDTO doctorDTO) {
//        DoctorEntity doctorEntity = new DoctorEntity();
//        System.err.println(doctorDTO);
//        BeanUtils.copyProperties(doctorDTO, doctorEntity);
//        doctorEntity.setSpecialisation(doctorDTO.getSpecialisation());
//        hospitalRepository.doctorSave(doctorEntity);
//        return true;
//    }


//    @Override
//    public boolean slot(SlotDTO slotDTO) {
//        SlotEntity slotEntity = new SlotEntity();
//        BeanUtils.copyProperties(slotDTO, slotEntity);
//        return hospitalRepository.saveSlot(slotEntity);
//    }

    // HospitalServiceImp.java
    @Override
    public List<DoctorEntity> getAllDoctors() {
        List<DoctorEntity> doctors = hospitalRepository.getAllDoctors();
        System.out.println("Doctors fetched from DB: " + doctors);
        return doctors;
    }

    @Override
    public List<SlotEntity> getAllSlots() {
        return hospitalRepository.getAllSlots();
    }


    @Override
    public List<SpecialisationEntity> getAllSpecialisation() {
        System.out.println("Specialisations fetched from DB: " + hospitalRepository.getAllSpecialisations());
        return hospitalRepository.getAllSpecialisations();
    }


//    public DoctorDTO findDoctorByEmail(String email) {
//        DoctorEntity entity = hospitalRepository.findDoctorByEmail(email);
//        System.out.println("Doctor entity fetched: " + entity);
//        if (entity != null) {
//            DoctorDTO dto = new DoctorDTO();
//            BeanUtils.copyProperties(entity, dto);
//
//
//                dto.setSpecialisation(dto.getSpecialisation()); // store id
//                //dto.setSpecialisation(entity.getSpecialisation().getSpecialisation()); // store name
//
//            return dto;
//        }
//        return null;
//    }

//    @Override
//    public SpecialisationEntity getById(int id) {
//        return hospitalRepository.getById(id);
//    }


//    public boolean updateDoctorByEmail(String email,DoctorDTO doctorDTO) {
//
//        DoctorEntity doctorEntity = new DoctorEntity();
//        BeanUtils.copyProperties(doctorDTO, doctorEntity);
//        return hospitalRepository.updateDoctorByEmail(email, doctorEntity);
//    }

    @Override
    public List<SlotEntity> getAllSlotSpecialisations(String specialisation) {
        return hospitalRepository.getAllSlotSpecialisations(specialisation);
    }

    @Override
    public boolean assignSlotToDoctor(String doctorName, String timeSlot) {
        DoctorEntity doctorEntity = hospitalRepository.findByName(doctorName);
        if (doctorEntity == null) {
            log.info("Doctor not found with name: " + doctorName);
            return false;
        }

        UpdatedTimeSlotEntity timeSlotEntity = new UpdatedTimeSlotEntity();
        timeSlotEntity.setDoctor(doctorEntity);
        timeSlotEntity.setTimeSlot(timeSlot);
        timeSlotEntity.setDoctorName(doctorEntity.getDoctorName());

        boolean updated = hospitalRepository.assignSlotToDoctor(timeSlotEntity);

        if (updated) {
            log.info("Slot assigned to doctor successfully");
            return true;
        }
        log.info("Failed to assign slot to doctor");
        return false;
    }


    @Override
    public List<DoctorEntity> getUnassignedDoctors(String specialisation) {
        return hospitalRepository.getUnassignedDoctors(specialisation);
    }
}

