package org.example.cottagebookingsystembackend.service;


import org.example.cottagebookingsystembackend.model.Reservation;
import org.example.cottagebookingsystembackend.model.ServicesOfReservation;
import org.example.cottagebookingsystembackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation getReservationById(Long id) {
        Optional<Reservation> optionalHousingReservation = reservationRepository.findById(id);
        return optionalHousingReservation.orElse(null);
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<ServicesOfReservation> getAllReservationsByDate(Date startDate, Date endDate) {
        return reservationRepository.findAllReservationsByDate(startDate, endDate);
    }
}