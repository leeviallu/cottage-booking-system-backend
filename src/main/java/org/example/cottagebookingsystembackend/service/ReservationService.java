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
    List<Reservation> getAllReservationsByDate(Date startDate, Date endDate);
}
