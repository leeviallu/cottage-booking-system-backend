package org.example.cottagebookingsystembackend.repository;

import jakarta.transaction.Transactional;
import org.example.cottagebookingsystembackend.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation r WHERE r.customer.customerId=:id")
    void deleteReservationsByCustomerId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Billing b WHERE b.reservationId IN (SELECT r.reservationId FROM Reservation r WHERE r.customer.customerId=:id)")
    void deleteBillingByCustomerId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ServicesOfReservation sor WHERE sor.reservation.reservationId IN (SELECT r.reservationId FROM Reservation r WHERE r.customer.customerId=:id)")
    void deleteSorByCustomerId(@Param("id") Long id);
}