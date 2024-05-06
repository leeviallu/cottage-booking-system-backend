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
    @Query("SELECT sor, s FROM ServicesOfReservation sor JOIN sor.reservation r JOIN sor.service s WHERE s.area.areaId=:areaId AND r.reservationStartingDate>:startDate AND r.reservationEndingDate<:endDate")
    List<ServicesOfReservation> findAllServiceReservationsByDate(@Param("areaId") long areaId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    @Query("SELECT r FROM ServicesOfReservation sor JOIN sor.reservation r JOIN sor.service s WHERE s.area.areaId=:areaId AND r.reservationStartingDate>:startDate and r.reservationEndingDate<:endDate")
    List<Reservation> findAllCottageReservationsByDate(@Param("areaId") long areaId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
