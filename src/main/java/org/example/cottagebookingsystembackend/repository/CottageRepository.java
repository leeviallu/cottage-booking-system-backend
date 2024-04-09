package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Cottage;
import org.springframework.data.repository.CrudRepository;

public interface CottageRepository extends CrudRepository<Cottage, Long> { }