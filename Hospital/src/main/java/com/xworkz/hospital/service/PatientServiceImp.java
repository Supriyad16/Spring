package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.BloodGroupDTO;
import com.xworkz.hospital.dto.PatientDTO;
import com.xworkz.hospital.dto.UpdatedTimeSlotDTO;
import com.xworkz.hospital.entity.*;
import com.xworkz.hospital.repository.DoctorRepository;
import com.xworkz.hospital.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PatientServiceImp implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<BloodGroupDTO> getAllBloodGroup() {
        List<BloodGroupEntity> entities = patientRepository.getAllBloodGroup();
        log.info(entities.toString());
        List<BloodGroupDTO> dtos = new ArrayList<>();
        for (BloodGroupEntity entity : entities) {
            BloodGroupDTO bloodGroupDto = new BloodGroupDTO();
            BeanUtils.copyProperties(entity, bloodGroupDto);
            dtos.add(bloodGroupDto);
        }
        return dtos;
    }


    @Override
    public List<UpdatedTimeSlotDTO> getTimeSlot(int id) {
        List<UpdatedTimeSlotEntity> updatedTimeSlotEntities = patientRepository.getTimeSlot(id);

        List<UpdatedTimeSlotDTO> updatedTimeSlotDTOS = new ArrayList<>();
        for (UpdatedTimeSlotEntity entity : updatedTimeSlotEntities) {
            UpdatedTimeSlotDTO dto = new UpdatedTimeSlotDTO();
            BeanUtils.copyProperties(entity, dto);
            updatedTimeSlotDTOS.add(dto);
        }
        return updatedTimeSlotDTOS;
    }


    @Override
    @Transactional
    public boolean patientSave(List<MultipartFile> multipartFiles, PatientDTO patientDTO) throws IOException {

        Path uploadPath = Paths.get("E:\\images\\");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setRegistrationId(patientDTO.getRegistrationId());
        patientEntity.setPatientName(patientDTO.getPatientName());
        patientEntity.setAge(patientDTO.getAge());
        patientEntity.setGender(patientDTO.getGender());
        patientEntity.setBloodGroup(patientDTO.getBloodGroup());
        patientEntity.setEmail(patientDTO.getEmail());
        patientEntity.setPhoneNumber(patientDTO.getPhoneNumber());
        patientEntity.setAddress(patientDTO.getAddress());
        patientEntity.setDisease(patientDTO.getDisease());
        patientEntity.setSpecialisation(patientDTO.getSpecialisation());
        patientEntity.setFees(patientDTO.getFees());
        patientEntity.setDoctorName(patientDTO.getDoctorName());
        patientEntity.setSlot(patientDTO.getSlot());

        List<PatientImageEntity> images = new ArrayList<>();

        for (MultipartFile file : multipartFiles) {
            if (!file.isEmpty()) {
//                String originalExtension = FilenameUtils.getExtension(file.getOriginalFilename());
//                String fileName = patientDTO.getPatientName() + "_" + System.currentTimeMillis() + "." + originalExtension;
//                Path filePath = uploadPath.resolve(fileName);
//                Files.copy(file.getInputStream(), filePath);

                String originalExtension = FilenameUtils.getExtension(file.getOriginalFilename());
                String uniqueId = java.util.UUID.randomUUID().toString().substring(0, 8);
                String fileName = patientDTO.getPatientName() + "_" + uniqueId + "." + originalExtension;
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), filePath);// StandardCopyOption.REPLACE_EXISTING);


                PatientImageEntity imageEntity = new PatientImageEntity();
                imageEntity.setOriginalImageName(file.getOriginalFilename());
                imageEntity.setFileType(file.getContentType());
                imageEntity.setFileSize(file.getSize());
                imageEntity.setFilePath(filePath.toString());
                imageEntity.setSavedName(fileName);
                imageEntity.setDateTime(new Timestamp(System.currentTimeMillis()));
                imageEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                imageEntity.setCreatedBy("SUPRIYA");
                imageEntity.setPatientEntity(patientEntity);

                images.add(imageEntity);
            }
        }

        patientEntity.setImages(images);

        // set doctor
        if (patientDTO.getDoctorId() != null) {
            DoctorEntity doctorEntity = doctorRepository.findById(patientDTO.getDoctorId());
            if (doctorEntity != null) {
                patientEntity.setDoctor(doctorEntity);
                patientEntity.setDoctorName(doctorEntity.getDoctorName());
            }
        }

        // set slot
        if (patientDTO.getSlotId() != null) {
            UpdatedTimeSlotEntity slotEntity = patientRepository.getInterval(patientDTO.getSlotId());
            if (slotEntity != null) {
                patientEntity.setSlotEntity(slotEntity);
                patientEntity.setSlot(slotEntity.getTimeSlot());
            }
        }

        patientRepository.patientSave(patientEntity);
        log.info("Patient saved with {} images", images.size());

        return true;
    }


}