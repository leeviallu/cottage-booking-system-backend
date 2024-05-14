package org.example.cottagebookingsystembackend.repository;

import jakarta.transaction.Transactional;
import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.example.cottagebookingsystembackend.model.ServicesOfReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicesOfReservationRepository extends JpaRepository<ServicesOfReservation, Long> {
    @Query("SELECT sor FROM ServicesOfReservation sor WHERE sor.reservationId=:id")
    List<ServicesOfReservation> findAllByReservationId(@Param("id") long id);

    @Query("SELECT sor FROM ServicesOfReservation sor WHERE sor.serviceId=:serviceId AND sor.reservationId=:reservationId")
    ServicesOfReservation findSorByServiceIdAndReservationId(@Param("serviceId") Long serviceId, @Param("reservationId") Long reservationId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ServicesOfReservation sor WHERE sor.serviceId=:serviceId AND sor.reservationId=:reservationId")
    void deleteFromSorByServiceIdAndReservationId(@Param("serviceId") Long serviceId, @Param("reservationId") Long reservationId);
}
