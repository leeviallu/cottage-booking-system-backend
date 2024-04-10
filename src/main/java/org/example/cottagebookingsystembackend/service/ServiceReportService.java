package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.ServiceModel;

import java.util.Optional;

public interface ServiceReportService {
    Optional<ServiceModel> findByName(String name);
}
