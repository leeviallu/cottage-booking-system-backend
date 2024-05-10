package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.Billing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BillingRepository extends CrudRepository<Billing, Long> {
    @Query("SELECT sor, b, cu, co FROM ServicesOfReservation sor JOIN sor.reservation r JOIN Billing b ON b.reservationId = r.reservationId JOIN Customer cu ON cu.customerId = r.customer.customerId JOIN Cottage co ON co.cottageId = r.cottage.cottageId WHERE r.confirmationDate>:confirmationDate")
    List<Object[]>  findReservationByConfirmationDate(@Param("confirmationDate") Date confirmationDate);
}