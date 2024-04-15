package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Billing;
import org.springframework.data.repository.CrudRepository;

public interface BillingRepository extends CrudRepository<Billing, Long> { }