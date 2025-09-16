package com.xworkz.hospital.repository;


import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.HospitalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class HospitalRepositoryImp implements HospitalRepository {

    @Autowired
    EntityManagerFactory emf;


    @Override
    public int getEmailCount(String email) {
        EntityManager em = null;
        EntityTransaction et = null;
        Integer count = 0;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("getEmailCount");
            query.setParameter("email", email);
            Object object = query.getSingleResult();
            Long result = (Long) query.getSingleResult();
            count = result.intValue();
            System.out.println("Count is " + count);
            System.out.println(object.toString());
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

            return count;
        }
    }

    @Override
    public HospitalEntity findByEmail(String email) {
        EntityManager em = null;
       // EntityTransaction et = null;
        HospitalEntity entity = null;


        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("getByEmail");
            query.setParameter("email", email);
            entity = (HospitalEntity) query.getSingleResult();

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
    public void save(HospitalEntity entity) {
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

    @Override
    public boolean doctorSave(DoctorEntity doctorEntity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(doctorEntity);
            et.commit();
            System.out.println("Doctor's Data Saved");

            return true;
        }
        catch (Exception e){
            if(et.isActive()){
                et.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return false;
    }
}

