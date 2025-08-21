package com.xworkz.library.repository;

import com.xworkz.library.entity.LibraryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class LibraryRepositoryImp implements LibraryRepository{

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean signUp(LibraryEntity entity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(entity);
            et.commit();
            System.out.println("Data Saved");

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
    public LibraryEntity signIn(String name) {


        EntityManager em = null;
        EntityTransaction et = null;
        LibraryEntity libraryEntity ;

        try{
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();


            Query query = em.createNamedQuery("getByUsernameAndPassword");
            query.setParameter("name",name);

            libraryEntity=(LibraryEntity) query.getSingleResult();

            System.out.println("Details are here");

            et.commit();
            return  libraryEntity;


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
        return null;
    }

    @Override
    public Boolean forgotPassword(String email, String password, String confirmPassword) {

        EntityManager em = null;
        EntityTransaction et = null;
        LibraryEntity libraryEntity = new LibraryEntity();

        try{
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("getEntityByEmail");
            query.setParameter("email",email);

            libraryEntity =(LibraryEntity) query.getSingleResult();


            System.out.println("Entity found");
            libraryEntity.setPassword(password);
            libraryEntity.setConfirmPassword(confirmPassword);
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


