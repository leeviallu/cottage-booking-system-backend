package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllReservationsByVarattuAlkupvmAfterAndVarattuLoppupvmBefore(Date startDate, Date endDate);
}