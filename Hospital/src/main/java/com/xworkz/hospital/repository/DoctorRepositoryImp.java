package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.DoctorEntity;
import com.xworkz.hospital.entity.ImageEntity;
import com.xworkz.hospital.entity.SpecialisationEntity;
import com.xworkz.hospital.entity.UpdatedTimeSlotEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j

public class DoctorRepositoryImp implements DoctorRepository {

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
    public boolean doctorSave(DoctorEntity doctorEntity) {
        System.err.println("============="+doctorEntity);
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(doctorEntity);
            et.commit();
            System.out.println("Doctor's Data Saved");
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public DoctorEntity findById(int id) {
        EntityManager manager = emf.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        DoctorEntity entity = null;
        try {
            transaction.begin();
            Query query = manager.createNamedQuery("DoctorEntity.getById");
            query.setParameter("id", id);
            entity = (DoctorEntity) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            manager.close();
        }
        return entity;
    }

    public List<DoctorEntity> getDoctorsBySpecialisation(String specialisation) {
        EntityManager em = null;
        List<DoctorEntity> doctors = null;

        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("DoctorEntity.getDoctorsBySpecialisation");
            query.setParameter("specialisation", specialisation);
            doctors = query.getResultList();
            System.out.println("*********");
            System.out.println("Doctors by specialisation: " + doctors);
            //   et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return doctors;
    }

    @Override
    public List<DoctorEntity> getAllDoctors() {
        EntityManager entityManager =null;
        EntityTransaction entityTransaction =null;
        List<DoctorEntity> doctorEntity = new ArrayList<>();

        try{
            entityManager =emf.createEntityManager();
            entityTransaction=entityManager.getTransaction();
            entityTransaction.begin();
            Query query =entityManager.createNamedQuery("DoctorEntity.getDoctorsProfilePicture");
            List<Object[]> result = query.getResultList();
            for (Object[] row : result) {
                DoctorEntity doctor = (DoctorEntity) row[0];
                doctorEntity.add(doctor);
                }
            log.info("{}",doctorEntity);
            entityTransaction.commit();
            return doctorEntity;

        }catch (Exception e){
            if(entityTransaction !=null && entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return doctorEntity;
    }


    @Override
    public boolean updateDoctor(DoctorEntity doctorEntity) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            // Fetch existing doctor
            Query query = em.createNamedQuery("DoctorEntity.findDoctorByEmail");
            query  .setParameter("email", doctorEntity.getEmail());

                   query .getSingleResult();

            if (query != null) {
                // Update doctor fields
                doctorEntity.setDoctorName(doctorEntity.getDoctorName());
                doctorEntity.setSpecialisation(doctorEntity.getSpecialisation());
                doctorEntity.setQualification(doctorEntity.getQualification());
                doctorEntity.setExperience(doctorEntity.getExperience());
                doctorEntity.setPhoneNumber(doctorEntity.getPhoneNumber());
                doctorEntity.setAge(doctorEntity.getAge());
                doctorEntity.setGender(doctorEntity.getGender());

                // Update image if new file provided
                if (doctorEntity.getImageEntity() != null) {
                    ImageEntity existingImage = doctorEntity.getImageEntity();
                    ImageEntity newImage = doctorEntity.getImageEntity();

                    if (existingImage == null) {
                        doctorEntity.setImageEntity(newImage);
                        newImage.setDoctor(doctorEntity);
                        em.persist(newImage);
                    } else {
                        existingImage.setSavedName(newImage.getSavedName());
                        existingImage.setFilePath(newImage.getFilePath());
                        existingImage.setUpdatedBy(newImage.getUpdatedBy());
                        existingImage.setUpdatedAt(newImage.getUpdatedAt());
                    }
                }

                em.merge(doctorEntity);
                et.commit();
                return true;
            }

        } catch (Exception e) {
            if (et != null && et.isActive()) et.rollback();
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
        return false;
    }


    @Override
    public DoctorEntity findDoctorByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT d FROM DoctorEntity d WHERE d.email = :email", DoctorEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteDoctorByEmail(String email) {
        EntityManager em = null;
        EntityTransaction et = null;
        DoctorEntity doctor = null;
        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            Query query = em.createNamedQuery("DoctorEntity.findDoctorByEmail");
            query.setParameter("email", email);

            doctor = (DoctorEntity) query.getSingleResult();

            if (doctor != null) {
                em.remove(doctor);
                et.commit();
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        return false;
    }


}
