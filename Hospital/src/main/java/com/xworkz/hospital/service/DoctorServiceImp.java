package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.ImageEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.entity.UpdatedTimeSlotEntity;
import com.xworkz.hospital.repository.DoctorRepository;
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
import java.util.Collections;
import java.util.List;

@Service
@Slf4j

public class DoctorServiceImp implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<SpecialisationEntity> getAllSpecialisation() {
        System.out.println("Specialisations fetched from DB: " + doctorRepository.getAllSpecialisations());
        return doctorRepository.getAllSpecialisations();
    }


    public List<DoctorDTO> getDoctorsBySpecialisation(String specialisation) {
        List<DoctorEntity> entities = doctorRepository.getDoctorsBySpecialisation(specialisation);
        List<DoctorDTO> dtos = new ArrayList<>();

        for (DoctorEntity entity : entities) {
            DoctorDTO dto = new DoctorDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        }

        return dtos;
    }


    @Override
    public boolean doctorSave(MultipartFile multipartFile, DoctorDTO doctorDTO) throws IOException {

        String originalExtension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String fileName = doctorDTO.getDoctorName() + "_" + System.currentTimeMillis() + "." + originalExtension;
        Path uploadPath = Paths.get("E:\\images\\");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(multipartFile.getInputStream(), filePath);

        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setOriginalImageName(multipartFile.getOriginalFilename());
        imageEntity.setFileType(multipartFile.getContentType());
        imageEntity.setFileSize(multipartFile.getSize());
        imageEntity.setFilePath(filePath.toString());
        imageEntity.setSavedName(fileName);
        imageEntity.setDateTime(new Timestamp(System.currentTimeMillis()));
        imageEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        imageEntity.setCreatedBy("SUPRIYA");

        DoctorEntity doctorEntity = new DoctorEntity();
        BeanUtils.copyProperties(doctorDTO, doctorEntity);

        doctorEntity.setImageEntity(imageEntity);
        imageEntity.setDoctor(doctorEntity);

        doctorRepository.doctorSave(doctorEntity);

        return true;
    }


    @Override
    @Transactional
    public boolean updateDoctor(MultipartFile file, DoctorDTO doctorDTO) {
        try {
            // Fetch existing doctor from DB
            DoctorEntity doctorEntity = doctorRepository.findDoctorByEmail(doctorDTO.getEmail());
            if (doctorEntity == null) {
                return false; // doctor not found
            }

            // Update doctor fields (excluding image)
            BeanUtils.copyProperties(doctorDTO, doctorEntity, "id", "imageEntity");

            // Handle new image upload
            if (file != null && !file.isEmpty()) {
                String originalExtension = FilenameUtils.getExtension(file.getOriginalFilename());
                String savedName = doctorDTO.getDoctorName() + "_" + System.currentTimeMillis() + "." + originalExtension;
                Path uploadPath = Paths.get("E:\\images\\");
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                Path filePath = uploadPath.resolve(savedName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                ImageEntity imageEntity = doctorEntity.getImageEntity();
                if (imageEntity == null) {
                    imageEntity = new ImageEntity();
                    imageEntity.setDoctor(doctorEntity);
                }

                imageEntity.setOriginalImageName(file.getOriginalFilename());
                imageEntity.setSavedName(savedName);
                imageEntity.setFileType(file.getContentType());
                imageEntity.setFileSize(file.getSize());
                imageEntity.setFilePath(filePath.toString());
                imageEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                imageEntity.setUpdatedBy("SUPRIYA");

                doctorEntity.setImageEntity(imageEntity);
            }

            doctorRepository.updateDoctor(doctorEntity);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public DoctorDTO findDoctorByEmail(String email) {
        DoctorEntity entity = doctorRepository.findDoctorByEmail(email);
        System.out.println("Doctor entity fetched: " + entity);
        if (entity != null) {
            DoctorDTO dto = new DoctorDTO();
            BeanUtils.copyProperties(entity, dto);


            dto.setSpecialisation(dto.getSpecialisation()); // store id
            //dto.setSpecialisation(entity.getSpecialisation().getSpecialisation()); // store name

            return dto;
        }
        return null;
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<DoctorEntity> entities = doctorRepository.getAllDoctors();
        List<DoctorDTO> dtos = new ArrayList<>();

        if (entities != null) {
            for (DoctorEntity entity : entities) {
                DoctorDTO dto = new DoctorDTO();
                BeanUtils.copyProperties(entity, dto);

                if (entity.getImageEntity() != null) {
                    dto.setImagePath(entity.getImageEntity().getSavedName()); // or getFilePath()
                }

                dtos.add(dto);
            }
        }

        return dtos;
    }

    @Override
    public boolean deleteDoctorByEmail(String email) {
        DoctorEntity doctorEntity = doctorRepository.findDoctorByEmail(email);
        if (doctorEntity != null) {
            doctorRepository.deleteDoctorByEmail(email);
            return true;
        }
        return false;
    }

    @Override
    public int getDoctorEmailCount(String email) {

        int count = doctorRepository.getDoctorEmailCount(email);
        System.out.println(count);
        return count;
    }
}


