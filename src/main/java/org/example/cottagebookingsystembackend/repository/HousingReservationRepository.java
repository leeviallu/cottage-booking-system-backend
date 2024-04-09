package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.HousingReservation;
import org.springframework.data.repository.CrudRepository;

public interface HousingReservationRepository extends CrudRepository<HousingReservation, Long> { }