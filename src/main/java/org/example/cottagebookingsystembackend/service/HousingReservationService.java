package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.HousingReservation;

import java.util.List;

public interface HousingReservationService {
    HousingReservation getHousingReservationById(Long id);
    void createHousingReservation(HousingReservation housingReservation);
    void updateHousingReservation(HousingReservation housingReservation);
    void deleteHousingReservation(Long id);
    List<HousingReservation> getAllHousingReservations();
}
