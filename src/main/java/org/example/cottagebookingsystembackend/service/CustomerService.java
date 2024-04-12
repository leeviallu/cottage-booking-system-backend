package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Customer;

import java.util.List;


public interface CustomerService {
    Customer getCustomerById(Long id);
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    List<Customer> getAllCustomers();
}

