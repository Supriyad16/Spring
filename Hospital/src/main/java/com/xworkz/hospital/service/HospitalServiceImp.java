package com.xworkz.hospital.service;


import com.xworkz.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImp implements HospitalService{

    @Autowired
    private HospitalRepository hospitalRepository;


    @Override
    public int getEmailCount(String email) {

        int count = hospitalRepository.getEmailCount(email);
        System.out.println(count);
        return count;
    }
}
