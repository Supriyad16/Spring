package com.xworkz.library.repository;

import com.xworkz.library.dto.LibraryDTO;
import com.xworkz.library.entity.LibraryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LibraryRepositoryImp implements LibraryRepository{

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean signUp(LibraryEntity entity) {
       // System.err.println(entity);
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

            return (LibraryEntity) query.getSingleResult();

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
    public void save(LibraryEntity entity) {

        EntityManager em = null;
        EntityTransaction et = null;
        LibraryEntity libraryEntity ;

        try {
            et.begin();
            em.merge(entity);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    @Override
    public Boolean forgotPassword(String email, String password, String confirmPassword) {

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("getByEmail");
            query.setParameter("email", email);

            LibraryEntity libraryEntity = (LibraryEntity) query.getSingleResult();


            if (libraryEntity != null) {
                libraryEntity.setPassword(password);
                libraryEntity.setConfirmPassword(confirmPassword);
                libraryEntity.setFailedAttempts(0);
                libraryEntity.setAccountLocked(false);
                libraryEntity.setLocalDateTime(null);
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
    public LibraryEntity findByEmail(String email) {

        EntityManager em = null;
        EntityTransaction et = null;
        LibraryEntity libraryEntity ;
        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            Query query = em.createNamedQuery("getByEmail");
            query.setParameter("email",email);

            List<LibraryEntity> results = query.getResultList();
            if (results.isEmpty()) {
                return null; // no user found
            }
            return results.get(0);

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
    @Transactional
    public void update(LibraryEntity entity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.merge(entity);
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
    }

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

