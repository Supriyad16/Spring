package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.repository.SlotRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotServiceImp implements SlotService {

    @Autowired
    SlotRepository slotRepository;


    @Override
    public List<SpecialisationEntity> getAllSpecialisation() {
        System.out.println("Specialisations fetched from DB: " + slotRepository.getAllSpecialisations());
        return slotRepository.getAllSpecialisations();
    }

    @Override
    public SpecialisationEntity getById(int id) {
        return slotRepository.getById(id);
    }

    @Override
    public boolean saveSlot(SlotDTO slotDTO) {
        SlotEntity slotEntity = new SlotEntity();
        BeanUtils.copyProperties(slotDTO, slotEntity);
        return slotRepository.saveSlot(slotEntity);
    }

}
