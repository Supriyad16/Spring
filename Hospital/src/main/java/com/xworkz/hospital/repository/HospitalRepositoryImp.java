package com.xworkz.hospital.repository;


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
}
