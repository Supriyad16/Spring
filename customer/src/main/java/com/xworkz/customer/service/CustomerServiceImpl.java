package com.xworkz.customer.service;

import com.xworkz.customer.entity.CustomerEntity;
import com.xworkz.customer.repository.CustomerRepository;
import com.xworkz.customer.repository.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {



    @Override
    public void save(List<CustomerEntity> list) {
        System.out.println("Service: Saving customers " + list);
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        customerRepository.save(list);

    }

    @Override
    public List<CustomerEntity> getAll() {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getAll();
    }

    @Override
    public List<CustomerEntity> getCustomerByName(String name) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getCustomerByName(name);
    }

    @Override
    public CustomerEntity getCustomerByNameAndPhone(String name, long phoneNumber) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getCustomerByNameAndPhone(name, phoneNumber);
    }

    @Override
    public List<CustomerEntity> getCustomerByAddress(String address) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getCustomerByAddress(address);
    }

    @Override
    public List<CustomerEntity> getCustomerByEmail(String email) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getCustomerByEmail(email);
    }

    @Override
    public CustomerEntity getByPhone(long phoneNumber) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getByPhone(phoneNumber);
    }

    @Override
    public String getNameByEmail(String email) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getNameByEmail(email);
    }

    @Override
    public CustomerEntity getNameAndAddressByPhone(long phoneNumber) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getNameAndAddressByPhone(phoneNumber);
    }

    @Override
    public List<String> getNamesByAddress(String address) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getNamesByAddress(address);
    }

    @Override
    public List<CustomerEntity> getNameAndEmailByAddress(String address) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        return customerRepository.getNameAndEmailByAddress(address);
    }
}
