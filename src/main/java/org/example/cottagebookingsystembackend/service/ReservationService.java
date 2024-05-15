package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    Reservation getReservationById(Long id);
    void createReservation(Reservation housingReservation);
    void updateReservation(Reservation housingReservation);
    void deleteReservation(Long id);
    List<Reservation> getAllReservations();
    List<Reservation> getAllReservationsByCottageIdAndDateBetween(long cottageId, Date startDate, Date endDate);
    List<Object[]> getAllServiceReservationsByDate(long areaId, Date startDate, Date endDate);
    List<Reservation> getAllCottageReservationsByDate(long areaId, Date startDate, Date endDate);
}
