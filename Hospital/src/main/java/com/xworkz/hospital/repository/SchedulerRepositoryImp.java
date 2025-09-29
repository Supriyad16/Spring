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
    public int deleteExpiredOtps() {
        LocalDateTime cutoff = LocalDateTime.now().minusMinutes(5);
        Query query = entityManager.createQuery(
                "DELETE FROM HospitalEntity h WHERE h.localDateTime < :cutoff");
        query.setParameter("cutoff", cutoff);
        return query.executeUpdate();
    }
}
