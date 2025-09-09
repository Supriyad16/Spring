package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.HospitalEntity;

public interface HospitalRepository {


    HospitalEntity findByEmail(String email);

    int getEmailCount(String email);

    void save(HospitalEntity entity);

}
