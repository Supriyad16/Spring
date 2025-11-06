package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.entity.UpdatedTimeSlotEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DoctorService {

    List<SpecialisationEntity> getAllSpecialisation();

    boolean doctorSave(MultipartFile multipartFile, DoctorDTO doctorDTO) throws IOException;

    List<DoctorDTO> getDoctorsBySpecialisation(String specialisation);

    List<DoctorDTO> getAllDoctors();

    boolean updateDoctor(MultipartFile file, DoctorDTO doctorDTO);

    DoctorDTO findDoctorByEmail(String email);

    boolean deleteDoctorByEmail(String email);

    int getDoctorEmailCount(String email);

}
