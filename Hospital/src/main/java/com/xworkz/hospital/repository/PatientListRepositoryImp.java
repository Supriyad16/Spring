package com.xworkz.hospital.repository;


import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.PatientEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
public class PatientListRepositoryImp implements PatientListRepository {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public List<PatientEntity> findPatientsByCriteria(String specialisation, int doctorId, int slotId) {
        log.info("Querying patients by {}, {}, {}", specialisation, doctorId, slotId);
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            // Named query should match the parameters defined in @NamedQuery inside PatientEntity
            Query query = em.createNamedQuery("PatientEntity.getAllPatients");
            query.setParameter("spec", specialisation);
            query.setParameter("docId", doctorId);
            query.setParameter("slotId", slotId);

            List<PatientEntity> result = query.getResultList();
            et.commit();
            return result;

        } catch (Exception e) {
            log.error("Error fetching patient list", e);
            if (et != null && et.isActive()) et.rollback();
        } finally {
            if (em != null) em.close();
        }
        return Collections.emptyList();
    }
}