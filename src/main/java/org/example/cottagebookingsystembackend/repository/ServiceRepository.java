package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> { }
