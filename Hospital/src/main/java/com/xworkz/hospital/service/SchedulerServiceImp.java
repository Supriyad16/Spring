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

    @Scheduled(fixedRate = 300000) // 300000 ms = 5 min
    public void clearExpiredOtpsTask() {
        System.out.println("Scheduler task started at: " + LocalDateTime.now());
        int rows = schedulerRepository.clearExpiredOtps();
        System.out.println("Expired OTPs cleared: " + rows);
    }
}
