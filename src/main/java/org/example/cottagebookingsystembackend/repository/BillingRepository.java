package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Billing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BillingRepository extends CrudRepository<Billing, Long> {
    @Query("SELECT sor, b FROM ServicesOfReservation sor JOIN Reservation r ON r.reservationId = sor.reservationId JOIN Billing b ON b.reservationId = r.reservationId WHERE r.confirmationDate<:confirmationDate")
    List<Object[]>  findReservationByConfirmationDate(@Param("confirmationDate") Date confirmationDate);
}