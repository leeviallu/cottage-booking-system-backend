package org.example.cottagebookingsystembackend.service;


import org.example.cottagebookingsystembackend.model.*;
import org.example.cottagebookingsystembackend.repository.BillingRepository;
import org.example.cottagebookingsystembackend.repository.CottageRepository;
import org.example.cottagebookingsystembackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final BillingRepository billingRepository;
    private final CottageRepository cottageRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, BillingRepository billingRepository, CottageRepository cottageRepository) {
        this.reservationRepository = reservationRepository;
        this.billingRepository = billingRepository;
        this.cottageRepository = cottageRepository;
    }

    @Override
    public Reservation getReservationById(Long id) {
        Optional<Reservation> optionalHousingReservation = reservationRepository.findById(id);
        return optionalHousingReservation.orElse(null);
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        Billing billing = new Billing();
        billing.setReservationId(reservation.getReservationId());
        Optional<Cottage> cottage = cottageRepository.findById(reservation.getCottage().getCottageId());
        if (cottage.isPresent()) {
            billing.setSum(cottage.get().getPrice());
        } else {
            billing.setSum(0);
        }
        billing.setIsPaid(false);
        billingRepository.save(billing);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteBillingByReservationId(id);
        reservationRepository.deleteSorByReservationId(id);
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    public List<Reservation> getAllReservationsByCottageIdAndDateBetween(long cottageId, Date startDate, Date endDate) {
        System.out.println(cottageId);
        return reservationRepository.findAllReservationByCottageIdAndDateBetween(cottageId, startDate, endDate);
    }

    @Override
    public List<Object[]> getAllServiceReservationsByDate(long areaId, Date startDate, Date endDate) {
        return reservationRepository.findAllServiceReservationsByAreaIdAndDate(areaId, startDate, endDate);
    }

    @Override
    public List<Reservation> getAllCottageReservationsByDate(long areaId, Date startDate, Date endDate) {
        return reservationRepository.findAllCottageReservationsByAreaIdAndDate(areaId, startDate, endDate);
    }
}