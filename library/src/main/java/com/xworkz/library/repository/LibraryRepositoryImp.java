package com.xworkz.library.repository;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;
import org.springframework.beans.BeanUtils;
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
        LibraryEntity libraryEntity = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("getByName");
            query.setParameter("name", name);

            try {
                libraryEntity = (LibraryEntity) query.getSingleResult();
            } catch (NoResultException e) {
                System.out.println("User not found with name: " + name);
                return null;
            }

            System.out.println("User Found");
            et.commit();
            return libraryEntity;

        } catch (Exception e) {
            if(et.isActive()){
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }


    @Override
    public Boolean forgotPassword(String email, String password, String confirmPassword) {

        EntityManager em = null;
        EntityTransaction et = null;
        LibraryEntity libraryEntity = new LibraryEntity();

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("getEntityByEmail");
            query.setParameter("email", email);

            libraryEntity = (LibraryEntity) query.getSingleResult();


            if (libraryEntity != null) {
                libraryEntity.setPassword(password);
                libraryEntity.setConfirmPassword(confirmPassword);
                libraryEntity.setFailedAttempts(0);
                libraryEntity.setAccountLocked(false);
                em.merge(libraryEntity);
                et.commit();
                return true;

            }
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
    public LibraryEntity findByName(String name) {

        EntityManager em = null;
        EntityTransaction et = null;
        LibraryEntity libraryEntity ;
        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("getByName");
            query.setParameter("name",name);

           libraryEntity =(LibraryEntity) query.getSingleResult();

        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
        } finally {
            if (em != null)
                em.close();
        }

        return null;
    }

    @Override
    public void update(LibraryDTO libraryDTO) {
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            LibraryEntity entity = new LibraryEntity();
            BeanUtils.copyProperties(libraryDTO, entity);

            em.merge(entity);
            et.commit();
        } catch (Exception e) {
            if (et != null && et.isActive()) et.rollback();
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }


    @Override
    public void lock(LibraryEntity entity) {
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.merge(entity);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }

//    @Override
//    public boolean updateprofile(LibraryEntity libraryEntity) {
//
//        EntityManager em = null;
//        EntityTransaction et = null;
//        try {
//            em = emf.createEntityManager();
//            et = em.getTransaction();
//            et.begin();
//
//            Query query = em.createNamedQuery("updateProfile");
//            query.setParameter("name", libraryEntity.getName());
//            query.setParameter("age",libraryEntity.getAge());
//            query.setParameter("address",libraryEntity.getAddress());
//            query.setParameter("libraryId",libraryEntity.getLibraryId());
//            query.setParameter("gender",libraryEntity.getGender());
//            query.setParameter("phoneNumber",libraryEntity.getPhoneNumber());
//            query.executeUpdate();
//            et.commit();
//        } catch (Exception e) {
//            if (et.isActive()) et.rollback();
//            e.printStackTrace();
//        } finally {
//            if (em != null) em.close();
//        }
//
//        return false;
//    }

}

