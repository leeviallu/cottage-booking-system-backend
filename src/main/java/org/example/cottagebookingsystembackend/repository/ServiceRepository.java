package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<ServiceModel, Long> { }
