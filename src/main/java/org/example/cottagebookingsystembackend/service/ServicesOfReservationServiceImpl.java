package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.ServicesOfReservation;
import org.example.cottagebookingsystembackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesOfReservationServiceImpl implements ServicesOfReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ServicesOfReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;

    }
    @Override
    public List<ServicesOfReservation> getSorByReservationId(Long id) {
        return null;
    }

    @Override
    public void createSor(ServicesOfReservation sor) {
    }


}

