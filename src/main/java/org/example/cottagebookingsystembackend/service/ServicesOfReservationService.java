package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.ServicesOfReservation;

import java.util.List;

public interface ServicesOfReservationService {
    List<ServicesOfReservation> getSorByReservationId(Long id);
    void createSor(ServicesOfReservation sor);
}
