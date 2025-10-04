package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.SlotDTO;
import com.xworkz.hospital.entity.SpecialisationEntity;

import java.util.List;

public interface SlotService {

    List<SpecialisationEntity> getAllSpecialisation();

    SpecialisationEntity getById(int id);

    boolean saveSlot(SlotDTO slotDTO);
}
