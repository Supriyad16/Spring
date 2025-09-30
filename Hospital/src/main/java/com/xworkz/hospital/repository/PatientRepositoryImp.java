package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.PatientEntity;
import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
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

            em.persist(patientEntity);
            et.commit();

            System.out.println("Patient details saved successfully: " + patientEntity);
            return true;

        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    @Override
    public List<SpecialisationEntity> getAllSpecialisations() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM SpecialisationEntity s");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<DoctorEntity> getAllDoctors(String specialisation) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            TypedQuery<DoctorEntity> query = em.createNamedQuery(
                    "DoctorEntity.getDoctorsBySpecialisation", DoctorEntity.class
            );
            query.setParameter("specName", specialisation);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (em != null) em.close();
        }
    }



    @Override
    public List<SlotEntity> getAllSlotSpecialisation(String specialisation) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery(
                    "SELECT s FROM SlotEntity s WHERE s.specialisation.specialisation = :spec", SlotEntity.class);
            query.setParameter("spec", specialisation);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

