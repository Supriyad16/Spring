package com.xworkz.hospital.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;

@Repository
public class SchedulerRepositoryImp implements SchedulerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int clearExpiredOtps() {
        LocalDateTime cutoff = LocalDateTime.now().minusMinutes(5);
        Query query = entityManager.createQuery(
                "UPDATE HospitalEntity h SET h.OTP = NULL WHERE h.localDateTime < :cutoff"
        );
        query.setParameter("cutoff", cutoff);
        return query.executeUpdate();
    }
}
