package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.ServicesOfReservation;
import org.example.cottagebookingsystembackend.repository.ReservationRepository;
import org.example.cottagebookingsystembackend.repository.ServicesOfReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesOfReservationServiceImpl implements ServicesOfReservationService {
    private final ServicesOfReservationRepository servicesOfReservationRepository;

    @Autowired
    public ServicesOfReservationServiceImpl(ServicesOfReservationRepository servicesOfReservationRepository) {
        this.servicesOfReservationRepository = servicesOfReservationRepository;

    }
    @Override
    public List<ServicesOfReservation> getSorByReservationId(Long id) {
        return servicesOfReservationRepository.findAll();
    }

    @Override
    public void createSor(ServicesOfReservation sor) {
        servicesOfReservationRepository.save(sor);
    }


}

