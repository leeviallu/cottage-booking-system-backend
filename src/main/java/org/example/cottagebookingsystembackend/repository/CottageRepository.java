package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Cottage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageRepository extends JpaRepository<Cottage, Long> { }