package com.xworkz.customer.repository;

import com.xworkz.customer.entity.CustomerEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public void save(List<CustomerEntity> list) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            for (CustomerEntity entity : list) {
                manager.persist(entity);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
    }

    @Override
    public List<CustomerEntity> getAll() {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        List<CustomerEntity> list = new ArrayList<>();
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getAllCustomers");
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return list;
    }

    @Override
    public List<CustomerEntity> getCustomerByName(String name) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        List<CustomerEntity> list = new ArrayList<>();
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getCustomerByName");
            query.setParameter("name", name);
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return list;
    }

    @Override
    public CustomerEntity getCustomerByNameAndPhone(String name, long phoneNumber) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        CustomerEntity entity = null;
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getCustomerByNameAndPhone");
            query.setParameter("name", name);
            query.setParameter("phone", phoneNumber);
            entity = (CustomerEntity) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return entity;
    }

    @Override
    public List<CustomerEntity> getCustomerByAddress(String address) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        List<CustomerEntity> list = new ArrayList<>();
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getCustomerByAddress");
            query.setParameter("address", address);
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return list;
    }

    @Override
    public List<CustomerEntity> getCustomerByEmail(String email) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        List<CustomerEntity> list = new ArrayList<>();
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getCustomerByEmail");
            query.setParameter("email", email);
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return list;
    }

    @Override
    public CustomerEntity getByPhone(long phoneNumber) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        CustomerEntity entity = null;
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getCustomerByPhone");
            query.setParameter("phone", phoneNumber);
            entity = (CustomerEntity) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return entity;
    }

    @Override
    public String getNameByEmail(String email) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        String name = null;
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getNameByEmail");
            query.setParameter("email", email);
            name = (String) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return name;
    }

    @Override
    public CustomerEntity getNameAndAddressByPhone(long phoneNumber) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        CustomerEntity entity = new CustomerEntity();
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getNameAndAddressByPhone");
            query.setParameter("phone", phoneNumber);

            Object[] result = (Object[]) query.getSingleResult();
            entity.setCustomerName((String) result[0]);
            entity.setAddress((String) result[1]);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return entity;
    }

    @Override
    public List<String> getNamesByAddress(String address) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        List<String> list = new ArrayList<>();
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getNamesByAddress");
            query.setParameter("address", address);
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return list;
    }

    @Override
    public List<CustomerEntity> getNameAndEmailByAddress(String address) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;
        List<CustomerEntity> list = new ArrayList<>();
        try {
            factory = Persistence.createEntityManagerFactory("customerUnit");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createNamedQuery("getNameAndEmailByAddress");
            query.setParameter("address", address);

            List<Object[]> results = query.getResultList();
            for (Object[] row : results) {
                CustomerEntity entity = new CustomerEntity();
                entity.setCustomerName((String) row[0]);
                entity.setEmail((String) row[1]);
                list.add(entity);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (manager != null) manager.close();
        }
        return list;
    }
}
