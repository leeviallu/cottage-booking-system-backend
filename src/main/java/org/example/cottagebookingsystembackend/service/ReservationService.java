package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Reservation;
import org.example.cottagebookingsystembackend.model.ServicesOfReservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    Reservation getReservationById(Long id);
    void createReservation(Reservation housingReservation);
    void updateReservation(Reservation housingReservation);
    void deleteReservation(Long id);
    List<Reservation> getAllReservations();
    List<ServicesOfReservation> getAllServiceReservationsByDate(Date startDate, Date endDate);
    List<Reservation> getAllCottageReservationsByDate(Date startDate, Date endDate);

}
