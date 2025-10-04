package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.SpecialsationDTO;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.repository.SpecialisationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpecialisationServiceImp implements SpecialisationService {

    @Autowired
    private SpecialisationRepository specialisationRepository;

    @Override
    public boolean specialisationSave(SpecialsationDTO specialsationDTO) {

        SpecialisationEntity specialisationEntity = new SpecialisationEntity();
        BeanUtils.copyProperties(specialsationDTO, specialisationEntity);
        return  specialisationRepository.specialisationSave(specialisationEntity);

    }


}
