package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.*;
import org.example.cottagebookingsystembackend.repository.BillingRepository;
import org.example.cottagebookingsystembackend.repository.ReservationRepository;
import org.example.cottagebookingsystembackend.repository.ServiceRepository;
import org.example.cottagebookingsystembackend.repository.ServicesOfReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesOfReservationServiceImpl implements ServicesOfReservationService {
    private final ServicesOfReservationRepository servicesOfReservationRepository;
    private final ReservationRepository reservationRepository;
    private final BillingRepository billingRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServicesOfReservationServiceImpl(ServicesOfReservationRepository servicesOfReservationRepository, ReservationRepository reservationRepository, BillingRepository billingRepository, ServiceRepository serviceRepository) {
        this.servicesOfReservationRepository = servicesOfReservationRepository;
        this.reservationRepository = reservationRepository;
        this.billingRepository = billingRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void createSor(ServicesOfReservation sor) {
        Optional<Reservation> reservation = reservationRepository.findById(sor.getReservationId());;
        Optional<ServiceModel> service = serviceRepository.findById(sor.getServiceId());

        if (service.isPresent() && reservation.isPresent() ) {
            Billing billing = billingRepository.findByReservationId(reservation.get().getReservationId());
            double sum = billing.getSum() + (service.get().getPrice() * sor.getCount());
            billing.setSum(sum);
            billingRepository.save(billing);
        } else {
            System.out.println("No reservation or service found");
        }

        servicesOfReservationRepository.save(sor);
    }

    @Override
    public List<ServicesOfReservation> getAllByReservationId(Long id) {
        return servicesOfReservationRepository.findAllByReservationId(id);
    }

    @Override
    public ServicesOfReservation getSorByServiceIdAndReservationId(Long serviceId, Long reservationId) {
        return servicesOfReservationRepository.findSorByServiceIdAndReservationId(serviceId, reservationId);
    }

    public void updateSor(ServicesOfReservation sor) {
        Optional<Reservation> reservation = reservationRepository.findById(sor.getReservationId());;
        Optional<ServiceModel> service = serviceRepository.findById(sor.getServiceId());

        if (service.isPresent() && reservation.isPresent() ) {
            Billing billing = billingRepository.findByReservationId(reservation.get().getReservationId());
            double sum = billing.getSum() + (service.get().getPrice() * sor.getCount());
            billing.setSum(sum);
            billingRepository.save(billing);
        } else {
            System.out.println("No reservation or service found");
        }

        ServicesOfReservation oldSor = servicesOfReservationRepository.findSorByServiceIdAndReservationId(sor.getServiceId(), sor.getReservationId());
        sor.setCount(oldSor.getCount() + sor.getCount());

        servicesOfReservationRepository.save(sor);
    }

    @Override
    public void deleteSor(Long serviceId, Long reservationId) {
        ServicesOfReservation sor = servicesOfReservationRepository.findSorByServiceIdAndReservationId(serviceId, reservationId);
        Optional<ServiceModel> service = serviceRepository.findById(serviceId);

        if (service.isPresent()) {
            Billing billing = billingRepository.findByReservationId(reservationId);
            double sum = billing.getSum() - (service.get().getPrice() * sor.getCount());
            billing.setSum(sum);
            billingRepository.save(billing);
        } else {
            System.out.println("No service found");
        }

        servicesOfReservationRepository.deleteFromSorByServiceIdAndReservationId(serviceId, reservationId);
    }
}

