package com.xworkz.library.repository;

import com.xworkz.library.entity.LibraryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class LibraryRepositoryImp implements LibraryRepository{

    @Override
    public boolean save(LibraryEntity entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(entity);
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

    @Override
    public LibraryEntity find(String name) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = null;
        EntityTransaction et = null;
        LibraryEntity libraryEntity = new LibraryEntity();

        try{
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();


            Query query = em.createNamedQuery("getSignUpDetails");
            query.setParameter("nameBy",name);

            libraryEntity=(LibraryEntity) query.getSingleResult();

            System.out.println(libraryEntity);

            et.commit();


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
        return libraryEntity;
    }

}
