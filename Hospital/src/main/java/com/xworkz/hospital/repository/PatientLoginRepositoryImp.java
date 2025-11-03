package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.PatientEntity;
import com.xworkz.hospital.entity.PatientLoginEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Slf4j
@Repository
public class PatientLoginRepositoryImp implements PatientLoginRepository {


    @Autowired
    EntityManagerFactory emf;

    @Override
    public int getPatientEmailCount(String email) {
        EntityManager em = null;
        EntityTransaction et = null;
        Integer count = 0;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("PatientEntity.getPatientEmailCount");
            query.setParameter("email", email);
            Long result = (Long) query.getSingleResult();
            count = result.intValue();
            System.out.println("Count is " + count);
            System.out.println(result.toString());
            et.commit();

        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();

        } finally {
            if (em != null) {
                em.close();
            }
        }
        return count;
    }

    @Override
    public PatientEntity findPatientByEmail(String email) {
        EntityManager em = null;
        PatientEntity entity = null;

        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("PatientEntity.getByEmail");
            query.setParameter("email", email);
            entity = (PatientEntity) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("No entity found for email: " + email);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return entity;
    }

    @Override
    public void save(PatientEntity entity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            em.merge(entity);
            et.commit();

            System.out.println("Entity saved successfully: " + entity);

        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
