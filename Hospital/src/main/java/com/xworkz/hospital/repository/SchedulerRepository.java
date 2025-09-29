package com.xworkz.hospital.repository;

import java.time.LocalDateTime;

public interface SchedulerRepository {

    int clearExpiredOtps();
}
