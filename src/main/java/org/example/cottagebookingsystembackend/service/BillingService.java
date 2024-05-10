package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Billing;

import java.util.Date;
import java.util.List;

public interface BillingService {
    Billing getBillingById(Long id);
    void createBilling(Billing billing);
    void updateBilling(Billing billing);
    void deleteBilling(Long id);
    List<Billing> getAllBillings();
    List<Object[]> getReservationsByConfirmationDate(Date confirmationDate);
}
