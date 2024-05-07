package org.example.cottagebookingsystembackend.repository;

import jakarta.transaction.Transactional;
import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends CrudRepository<ServiceModel, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM ServicesOfReservation sor WHERE sor.service.serviceId=:id")
    void deleteFromSorByServiceId(@Param("id") Long id);
}
