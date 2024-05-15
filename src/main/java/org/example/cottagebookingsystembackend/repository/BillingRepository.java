package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Billing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BillingRepository extends CrudRepository<Billing, Long> {
    @Query("SELECT r, s, b, sor FROM Reservation r LEFT JOIN ServicesOfReservation sor ON r.reservationId = sor.reservationId LEFT JOIN ServiceModel s ON s.serviceId = sor.serviceId JOIN Billing b ON b.reservationId = r.reservationId WHERE r.confirmationDate<:confirmationDate")
    List<Object[]> findReservationByConfirmationDate(@Param("confirmationDate") Date confirmationDate);

    @Query("SELECT b FROM Billing b WHERE b.reservationId=:id")
    Billing findByReservationId(long id);
}