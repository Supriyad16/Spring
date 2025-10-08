package com.xworkz.hospital.repository;

import com.xworkz.hospital.dto.UpdatedTimeSlotDTO;
import com.xworkz.hospital.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
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
        public List<BloodGroupEntity> getAllBloodGroup() {

            EntityManager em =emf.createEntityManager();
            EntityTransaction et=em.getTransaction();
            List<BloodGroupEntity> bloodGroupEntities = null;
            try {
                et.begin();
                Query query=em.createNamedQuery("getAllBloodGroup");
                bloodGroupEntities= query.getResultList();
                et.commit();
            } catch (Exception e) {
                if (et.isActive()) {
                    et.rollback();
                }
            } finally {
                em.close();
            }
            return bloodGroupEntities;
        }


//@Override
//public List<UpdatedTimeSlotEntity> getTimeSlot(int  id) {
//    EntityManager manager=emf.createEntityManager();
//    EntityTransaction transaction=manager.getTransaction();
//    List<UpdatedTimeSlotEntity> interval=null;
//    try {
//        transaction.begin();
//        Query query=manager.createNamedQuery("getTimeSlotId");
//        query.setParameter("id",id);
//        interval=query.getResultList();
//
//        transaction.commit();
//    } catch (Exception e) {
//        if (transaction.isActive()) {
//            transaction.rollback();
//        }
//    } finally {
//        manager.close();
//    }
//    return interval;
//}

    public List<UpdatedTimeSlotEntity> getTimeSlot(int id) {
        EntityManager em = emf.createEntityManager();
        List<UpdatedTimeSlotEntity> slots;

        try {
            // Fetch slots using the named query
            slots = em.createNamedQuery("getTimeSlotId", UpdatedTimeSlotEntity.class)
                    .setParameter("id", id)
                    .getResultList();
        } finally {
            em.close();
        }

        return slots;
    }



    @Override
    public UpdatedTimeSlotEntity getInterval(int id) {
        EntityManager em=emf.createEntityManager();
        EntityTransaction transaction=em.getTransaction();
        UpdatedTimeSlotEntity interval=null;
        try {
            transaction.begin();
            Query query=em.createNamedQuery("getIntervalById");
            query.setParameter("id",id);
            interval=(UpdatedTimeSlotEntity) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
        return interval;
    }


}




