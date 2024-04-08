package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.HousingReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingReservationRepository extends JpaRepository<HousingReservation, Long> { }