package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.ServiceModel;


import java.util.List;


public interface ServiceService {
    ServiceModel getServiceById(Long id);

    void createService(ServiceModel service);

    void updateService(ServiceModel service);

    void deleteService(Long id);

    List<ServiceModel> getAllServices();
}
