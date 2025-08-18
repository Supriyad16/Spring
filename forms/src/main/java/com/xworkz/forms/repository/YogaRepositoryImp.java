package com.xworkz.forms.repository;

import com.xworkz.forms.entity.YogaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class YogaRepositoryImp implements YogaRepository{
    @Override
    public boolean save(YogaEntity yogaEntity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(yogaEntity);
            et.commit();

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
