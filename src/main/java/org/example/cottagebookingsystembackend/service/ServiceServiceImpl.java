package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.example.cottagebookingsystembackend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;


    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public ServiceModel getServiceById(Long id) {
        Optional<ServiceModel> optionalService= serviceRepository.findById(id);
        return optionalService.orElse(null);
    }

    @Override
    public void createService(ServiceModel service) {
        serviceRepository.save(service);
    }

    @Override
    public void updateService(ServiceModel service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public List<ServiceModel> getAllServices() {
        return serviceRepository.findAll();
    }

}
