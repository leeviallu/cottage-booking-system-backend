package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.ServicesOfReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ServicesOfReservationRepository extends JpaRepository<ServicesOfReservation, Long> {

}
