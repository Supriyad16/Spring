package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.PatientEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class PatientRepositoryImp implements PatientRepository {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean patientSave(PatientEntity patientEntity) {

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            em.merge(patientEntity);
            et.commit();

            System.out.println("Entity saved successfully: " + patientEntity);

        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            return false;
        }
    }

    }

