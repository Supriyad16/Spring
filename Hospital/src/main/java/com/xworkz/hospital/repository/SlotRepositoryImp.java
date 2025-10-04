package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.SlotEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


@Repository
@Slf4j
public class SlotRepositoryImp implements SlotRepository {

    @Autowired
    EntityManagerFactory emf;

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
    public SpecialisationEntity getById(int id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            return em.find(SpecialisationEntity.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public boolean saveSlot(SlotEntity slotEntity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(slotEntity);
            et.commit();
            System.out.println("Slot Assigned");
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
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
