package com.xworkz.customer.repository;

import com.xworkz.customer.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepository {

    void save(List<CustomerEntity> list);

    List<CustomerEntity> getAll();

    List<CustomerEntity> getCustomerByName(String name);

    CustomerEntity getCustomerByNameAndPhone(String name, long phoneNumber);

    List<CustomerEntity> getCustomerByAddress(String address);

    List<CustomerEntity> getCustomerByEmail(String email);

    CustomerEntity getByPhone(long phoneNumber);

    String getNameByEmail(String email);

    CustomerEntity getNameAndAddressByPhone(long phoneNumber);

    List<String> getNamesByAddress(String address);

    List<CustomerEntity> getNameAndEmailByAddress(String address);
}
