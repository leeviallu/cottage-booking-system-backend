package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.example.cottagebookingsystembackend.repository.ServiceReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceReportServiceImpl implements ServiceReportService {
    private final ServiceReportRepository serviceReportRepository;

    @Autowired
    public ServiceReportServiceImpl(ServiceReportRepository serviceReportRepository) {
        this.serviceReportRepository = serviceReportRepository;
    }

    @Override
    public Optional<ServiceModel> findByName(String name) {
        System.out.println(name);
        return Optional.ofNullable((ServiceModel) serviceReportRepository.findByName(name));
    }
}
