package com.xworkz.customer.runner;

import com.xworkz.customer.entity.CustomerEntity;
import com.xworkz.customer.service.CustomerService;
import com.xworkz.customer.service.CustomerServiceImpl;

import java.util.List;

public class CustomerRunner {

        public void main(String[] args) {

            CustomerService customerService = new CustomerServiceImpl();
            CustomerEntity[] customers = {
                    new CustomerEntity(1, "Aarav Sharma", "aarav.sharma@gmail.com", 9876543210L, "Delhi"),
                    new CustomerEntity(2, "Priya Singh", "priya.singh@gmail.com", 9123456780L, "Mumbai"),
                    new CustomerEntity(3, "Rohan Mehta", "rohan.mehta@yahoo.com", 9988776655L, "Bengaluru"),
                    new CustomerEntity(4, "Sneha Gupta", "sneha.gupta@gmail.com", 9112233445L, "Kolkata"),
                    new CustomerEntity(5, "Aditya Verma", "aditya.verma@outlook.com", 9098765432L, "Pune"),
                    new CustomerEntity(6, "Kavya Nair", "kavya.nair@gmail.com", 9345678901L, "Chennai"),
                    new CustomerEntity(7, "Vikram Rao", "vikram.rao@yahoo.com", 9988001122L, "Hyderabad"),
                    new CustomerEntity(8, "Neha Bansal", "neha.bansal@gmail.com", 9876501234L, "Ahmedabad"),
                    new CustomerEntity(9, "Rajesh Kumar", "rajesh.kumar@gmail.com", 9123459876L, "Jaipur"),
                    new CustomerEntity(10, "Meera Joshi", "meera.joshi@gmail.com", 9786543210L, "Lucknow")
            };

            for (CustomerEntity customer : customers) {
                System.out.println(customer);
            }

            System.out.println("Getting all customer data from db...");
            List<CustomerEntity> list = customerService.getAll();
            list.forEach(System.out::println);

            System.out.println("All Data by Name");
            List<CustomerEntity> list1 = customerService.getCustomerByName("Ramesh");
            list1.forEach(System.out::println);

            System.out.println("All data by name and phone");
            CustomerEntity customerEntity = customerService.getCustomerByNameAndPhone("Asha", 9876543210L);
            System.out.println(customerEntity);

//            System.out.println("All data where age>25");
//            List<CustomerEntity> list2 = customerService.getCustomerByAge();
//            list2.forEach(System.out::println);
//
//            System.out.println("Get data between age 20 and 30");
//            List<CustomerEntity> list3 = customerService.getAgeBetween();
//            list3.forEach(System.out::println);
//
//            System.out.println("Get data by email");
//            CustomerEntity customerEntity1 = customerService.getByEmail("asha.k@example.com");
//            System.out.println(customerEntity1);
//
//            System.out.println("Get data from phoneNo");
//            CustomerEntity customerEntity2 = customerService.getByPhone(9876543210L);
//            System.out.println(customerEntity2);
        }
}



