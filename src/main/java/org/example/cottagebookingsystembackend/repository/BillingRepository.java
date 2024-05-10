package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Billing;
import org.example.cottagebookingsystembackend.model.ServicesOfReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BillingRepository extends CrudRepository<Billing, Long> {
    /*@Query("SELECT r FROM Reservation r WHERE r.confirmationDate>:confirmationDate")
    List<Reservation> findReservationByConfirmationDate(@Param("confirmationDate") Date confirmationDate);


     */
    @Query("SELECT s, r, b FROM ServicesOfReservation sor JOIN sor.service s JOIN sor.reservation r JOIN Billing b ON b.reservationId = r.reservationId WHERE r.confirmationDate>:confirmationDate")
    List<Object[]> findReservationByConfirmationDate(@Param("confirmationDate") Date confirmationDate);
}