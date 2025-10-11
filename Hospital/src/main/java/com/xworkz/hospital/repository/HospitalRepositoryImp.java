package com.xworkz.hospital.repository;

import com.xworkz.hospital.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Slf4j
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

//    @Override
//    public boolean doctorSave(DoctorEntity doctorEntity) {
//        System.err.println("============="+doctorEntity);
//        EntityManager em = null;
//        EntityTransaction et = null;
//
//        try {
//            em = emf.createEntityManager();
//            et = em.getTransaction();
//
//            et.begin();
//            em.persist(doctorEntity);
//            et.commit();
//            System.out.println("Doctor's Data Saved");
//            return true;
//        } catch (Exception e) {
//            if (et.isActive()) {
//                et.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//        return false;
//    }

//    @Override
//    public boolean saveSlot(SlotEntity slotEntity) {
//        EntityManager em = null;
//        EntityTransaction et = null;
//
//        try {
//            em = emf.createEntityManager();
//            et = em.getTransaction();
//
//            et.begin();
//            em.persist(slotEntity);
//            et.commit();
//            System.out.println("Slot Assigned");
//            return true;
//        } catch (Exception e) {
//            if (et.isActive()) {
//                et.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//        return false;
//    }


    @Override
    public List<DoctorEntity> getAllDoctors() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT d FROM DoctorEntity d", DoctorEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public List<SlotEntity> getAllSlots() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT s FROM SlotEntity s");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (em != null) em.close();
        }
    }

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
    public DoctorEntity findDoctorById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(DoctorEntity.class, id);
        } finally {
            em.close();
        }
    }

//    @Override
//    public DoctorEntity findDoctorByEmail(String email) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            return em.createQuery("SELECT d FROM DoctorEntity d WHERE d.email = :email", DoctorEntity.class)
//                    .setParameter("email", email)
//                    .getSingleResult();
//
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }

//    @Override
//    public SpecialisationEntity getById(int id) {
//        EntityManager em = null;
//        try {
//            em = emf.createEntityManager();
//            return em.find(SpecialisationEntity.class, id);
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }

    @Override
    public SlotEntity findSlotById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(SlotEntity.class, id);
        } finally {
            em.close();
        }
    }

//    @Override
//    public SpecialisationEntity findSpecialisationById(String specialisation) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            return em.find(SpecialisationEntity.class, specialisation);
//        } finally {
//            em.close();
//        }
//    }

    @Override
    public List<SlotEntity> getAllSlotSpecialisations(String specialisation) {
        EntityManager em = null;
        EntityTransaction et = null;
        em = emf.createEntityManager();
        et = em.getTransaction();
        List<SlotEntity> slots = null;

        try {
            et.begin();
            Query query = em.createNamedQuery("getAllSlotSpecialisations");
            query.setParameter("specialisation", specialisation);
            slots = query.getResultList();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        }
            finally{
                em.close();
            }
            return slots;
        }


//    public boolean updateDoctorByEmail(String email, DoctorEntity doctorEntity) {
//        EntityManager em = null;
//        EntityTransaction et = null;
//
//        try {
//            em = emf.createEntityManager();
//            et = em.getTransaction();
//            et.begin();
//
//            DoctorEntity entity = em.createQuery(
//                            "SELECT d FROM DoctorEntity d WHERE d.email = :email", DoctorEntity.class)
//                    .setParameter("email", email)
//                    .getSingleResult();
//
//            if (entity != null) {
//
//                entity.setDoctorName(doctorEntity.getDoctorName());
//                entity.setSpecialisation(doctorEntity.getSpecialisation());
//                entity.setQualification(doctorEntity.getQualification());
//                entity.setExperience(doctorEntity.getExperience());
//                entity.setPhoneNumber(doctorEntity.getPhoneNumber());
//                entity.setAge(doctorEntity.getAge());
//                entity.setGender(doctorEntity.getGender());
//
//                em.merge(entity);
//                et.commit();
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (et.isActive()) et.rollback();
//        } finally {
//            em.close();
//        }
//        return false;
//    }



    public List<DoctorEntity> getUnassignedDoctors(String specialisation) {
        EntityManager em = null;
        EntityTransaction et = null;
        List<DoctorEntity> doctors = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            Query query = em.createNamedQuery("DoctorEntity.getDoctorsBySpecialisation");
            query.setParameter("specialisation", specialisation);
            doctors = query.getResultList();
            System.out.println("*********");
            System.out.println("Unassigned Doctors: " + doctors);
        //   et.commit();
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return doctors;
    }

    public void updateDoctor(DoctorEntity doctor) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.merge(doctor);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

   @Override
    public boolean assignSlotToDoctor(UpdatedTimeSlotEntity updatedTimeSlotEntity) {
        EntityManager em =null;
        EntityTransaction et = null;

        try {

          em = emf.createEntityManager();
          et = em.getTransaction();
            et.begin();
            em.persist(updatedTimeSlotEntity);
            et.commit();
            return true;

        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

//    public boolean deleteDoctorByEmail(String email) {
//        EntityManager em = null;
//        EntityTransaction et = null;
//        DoctorEntity doctor = null;
//        try {
//            em = emf.createEntityManager();
//            et = em.getTransaction();
//            et.begin();
//            Query query = em.createNamedQuery("DoctorEntity.findDoctorByEmail");
//            query.setParameter("email", email);
//
//            doctor = (DoctorEntity) query.getSingleResult();
//
//            if (doctor != null) {
//                em.remove(doctor);
//                et.commit();
//                return true;
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            em.close();
//        }
//        return false;
//    }


    @Override
    public DoctorEntity findByName(String doctorName) {
        EntityManager em = null;
        EntityTransaction et = null;
        DoctorEntity doctor = null;

        try{
            em = emf.createEntityManager();
            et =em.getTransaction();
            et.begin();

            Query query= em.createNamedQuery("DoctorEntity.findByName");
            query.setParameter("doctorName",doctorName);
            doctor =(DoctorEntity) query.getSingleResult();
            et.commit();
            return doctor;

        }catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }finally {
            em.close();
        }

        return null;
    }
}

