package com.xworkz.hospital.service;

import com.xworkz.hospital.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SchedulerServiceImp implements SchedulerService {

    @Autowired
    private SchedulerRepository schedulerRepository;

    @Value("${otp.expiry.minutes}")
    private int otpExpiryMinutes;

    @Scheduled(fixedRateString = "300000") // runs every 5 minutes
    @Transactional  // Spring-managed transaction
    public void cleanExpiredOtps() {
        LocalDateTime cutoff = LocalDateTime.now().minusMinutes(otpExpiryMinutes);
        int deleted = schedulerRepository.deleteExpiredOtps();
        System.out.println("Expired OTPs cleaned: " + deleted + " | Expiry: " + otpExpiryMinutes + " minutes");
    }
}
