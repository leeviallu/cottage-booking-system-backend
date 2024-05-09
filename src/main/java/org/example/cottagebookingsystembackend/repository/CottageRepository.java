package org.example.cottagebookingsystembackend.repository;

import jakarta.transaction.Transactional;
import org.example.cottagebookingsystembackend.model.Cottage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CottageRepository extends CrudRepository<Cottage, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation r WHERE r.cottage.cottageId=:id")
    void deleteReservationsByCottageId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Billing b WHERE b.reservationId IN (SELECT r.reservationId FROM Reservation r WHERE r.cottage.cottageId=:id)")
    void deleteBillingByCottageId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ServicesOfReservation sor WHERE sor.reservation.reservationId IN (SELECT r.reservationId FROM Reservation r WHERE r.cottage.cottageId=:id)")
    void deleteSorByCottageId(@Param("id") Long id);
}