package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Billing;
import org.example.cottagebookingsystembackend.model.Reservation;
import org.example.cottagebookingsystembackend.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillingServiceImpl implements BillingService {
    private final BillingRepository billingRepository;

    @Autowired
    public BillingServiceImpl(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @Override
    public Billing getBillingById(Long id) {
        Optional<Billing> optionalBilling = billingRepository.findById(id);
        return optionalBilling.orElse(null);
    }
   /* @Override
    public List<Reservation> getReservationsByConfirmationDate(Date confirmationDate) {
        return (List<Reservation>) billingRepository.findReservationByConfirmationDate(confirmationDate);
    }

    */
    @Override
    public void createBilling(Billing billing) {
        billingRepository.save(billing);
    }

    @Override
    public void updateBilling(Billing billing) {
        billingRepository.save(billing);
    }

    @Override
    public void deleteBilling(Long id) {
        billingRepository.deleteById(id);
    }

    public List<Billing> getAllBillings() {
        return (List<Billing>) billingRepository.findAll();
    }
    @Override
    public List<Object[]> getReservationsByConfirmationDate(Date confirmationDate) {
        List<Object[]> results = billingRepository.findReservationByConfirmationDate(confirmationDate);

        return results;
      /*  List<Reservation> reservations = results.stream()
                .map(result -> {
                    System.out.println(Arrays.toString(result));
                    System.out.println(result[0]);
                    System.out.println(result[1]);
                    Reservation reservation = (Reservation) result[2];
                    System.out.println(reservation.getReservationId());

                    return reservation;
                })
                .collect(Collectors.toList());
        return reservations;

       */
    }
}

