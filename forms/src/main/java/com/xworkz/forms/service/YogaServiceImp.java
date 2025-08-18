package com.xworkz.forms.service;

import com.xworkz.forms.entity.YogaEntity;
import com.xworkz.forms.repository.YogaRepository;
import com.xworkz.forms.repository.YogaRepositoryImp;

public class YogaServiceImp implements YogaService{
    @Override
    public boolean save(YogaEntity yogaEntity) {

        YogaRepository yogaRepository = new YogaRepositoryImp();
        return yogaRepository.save(yogaEntity);
    }
}
