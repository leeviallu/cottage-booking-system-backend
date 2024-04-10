package org.example.cottagebookingsystembackend.repository;

import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ServiceReportRepository extends JpaRepository<ServiceModel, Long> {
    @Query("SELECT s FROM ServiceModel s WHERE s.nimi = ?1")
    ServiceModel findByName(String name);
}
