package org.example.cottagebookingsystembackend.repository;

import jakarta.transaction.Transactional;
import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends CrudRepository<ServiceModel, Long> {
    @Query("SELECT s FROM ServiceModel s WHERE s.area.areaId=:areaId")
    List<ServiceModel> findAllServicesByAreaId(@Param("areaId") long areaId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ServicesOfReservation sor WHERE sor.serviceId=:id")
    void deleteFromSorByServiceId(@Param("id") Long id);


}
