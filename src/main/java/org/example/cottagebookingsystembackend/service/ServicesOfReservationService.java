package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.ServicesOfReservation;

import java.util.List;

public interface ServicesOfReservationService {
    List<ServicesOfReservation> getAllByReservationId(Long id);
    ServicesOfReservation getSorByServiceIdAndReservationId(Long serviceId, Long reservationId);

    void createSor(ServicesOfReservation sor);
    void deleteSor(Long serviceId, Long reservationId);
}
