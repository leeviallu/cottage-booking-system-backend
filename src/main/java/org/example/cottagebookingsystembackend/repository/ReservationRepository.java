package org.example.cottagebookingsystembackend.repository;

import jakarta.transaction.Transactional;
import org.example.cottagebookingsystembackend.model.Reservation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    @Query("SELECT s, sor FROM ServicesOfReservation sor JOIN Reservation r ON sor.reservationId = r.reservationId JOIN ServiceModel s ON sor.serviceId = s.serviceId WHERE s.area.areaId=:areaId AND r.reservationStartingDate>:startDate AND r.reservationEndingDate<:endDate")
    List<Object[]> findAllServiceReservationsByAreaIdAndDate(@Param("areaId") long areaId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT r FROM Reservation r JOIN r.cottage c WHERE c.area.areaId=:areaId AND r.reservationStartingDate>:startDate and r.reservationEndingDate<:endDate")
    List<Reservation> findAllCottageReservationsByAreaIdAndDate(@Param("areaId") long areaId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT r FROM Reservation r JOIN r.cottage c WHERE r.cottage.cottageId=:cottageId AND ((r.reservationStartingDate<:startDate AND r.reservationEndingDate>:startDate) OR (r.reservationEndingDate>:endDate AND r.reservationStartingDate<:endDate) OR (r.reservationStartingDate>:startDate AND r.reservationEndingDate<:endDate))")
    List<Reservation> findAllReservationByCottageIdAndDateBetween(@Param("cottageId") long cottageId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Modifying
    @Transactional
    @Query("DELETE FROM Billing b WHERE b.reservationId=:id")
    void deleteBillingByReservationId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ServicesOfReservation sor WHERE sor.reservationId=:id")
    void deleteSorByReservationId(@Param("id") Long id);
}
