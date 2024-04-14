package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Reservation;
import org.example.cottagebookingsystembackend.model.ServicesOfReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT sor, s, s FROM ServicesOfReservation sor JOIN sor.reservation r JOIN sor.service s WHERE r.reservationStartingDate>:startDate and r.reservationEndingDate<:endDate")
    List<ServicesOfReservation> findAllReservationsByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}