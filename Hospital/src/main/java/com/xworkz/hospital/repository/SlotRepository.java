package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;

import java.util.List;

public interface SlotRepository {

    List<SpecialisationEntity> getAllSpecialisations();

    SpecialisationEntity getById(int id);

    boolean saveSlot(SlotEntity slotEntity);
}
