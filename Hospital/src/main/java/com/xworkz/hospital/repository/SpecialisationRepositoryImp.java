package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.SpecialisationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
@Slf4j

public class SpecialisationRepositoryImp implements SpecialisationRepository {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean specialisationSave(SpecialisationEntity specialisationEntity) {

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            em.merge(specialisationEntity);
            et.commit();

            System.out.println("Entity saved successfully: " + specialisationEntity);
            return true;

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
        return false;
    }
}
