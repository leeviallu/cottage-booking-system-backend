package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.Billing;
import org.example.cottagebookingsystembackend.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billings")
public class BillingController {
    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/{id}")
    public Billing getBillingById(@PathVariable Long id) {
        return billingService.getBillingById(id);
    }

    @GetMapping
    public List<Billing> getAllCottages() {
        return billingService.getAllBillings();
    }

    @PostMapping
    public ResponseEntity<String> createBilling(@RequestBody Billing billing) {
        if (billing.getBillingId() == null || billing.getReservationId() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        billingService.createBilling(billing);
        return ResponseEntity.ok("Billing has been created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBilling(@PathVariable Long id, @RequestBody Billing billing) {
        Billing existingBilling = billingService.getBillingById(id);
        if (existingBilling != null) {
            billing.setBillingId(id);
            if (billing.getBillingId() == null || billing.getBillingId() == null || billing.getReservationId() == null) {
                return ResponseEntity.unprocessableEntity().build();
            }
            billingService.updateBilling(billing);
            return ResponseEntity.ok("Billing updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBilling(@PathVariable Long id) {
        Billing existingBilling = billingService.getBillingById(id);
        if (existingBilling != null) {
            billingService.deleteBilling(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}