package org.example.cottagebookingsystembackend.repository;

import jakarta.transaction.Transactional;
import org.example.cottagebookingsystembackend.model.Area;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AreaRepository extends CrudRepository<Area, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Cottage c WHERE c.area.areaId=:id")
    void deleteCottagesByAreaId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation r WHERE r.cottage.cottageId IN (SELECT c.cottageId FROM Cottage c WHERE c.area.areaId=:id)")
    void deleteReservationsByAreaId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ServicesOfReservation sor WHERE sor.reservationId IN (SELECT r.reservationId FROM Reservation r WHERE r.cottage.cottageId IN (SELECT c.cottageId FROM Cottage c WHERE c.area.areaId=:id))")
    void deleteSorReservationByAreaId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ServicesOfReservation sor WHERE sor.serviceId IN (SELECT s.serviceId FROM ServiceModel s WHERE s.area.areaId=:id)")
    void deleteSorServiceByAreaId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ServiceModel s WHERE s.area.areaId=:id")
    void deleteServiceByAreaId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Billing b WHERE b.reservationId IN (SELECT r.reservationId FROM Reservation r WHERE r.cottage.cottageId IN (SELECT c.cottageId FROM Cottage c WHERE c.area.areaId=:id))")
    void deleteBillingByAreaId(@Param("id") Long id);
}