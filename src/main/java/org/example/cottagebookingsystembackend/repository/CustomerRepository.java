package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> { }