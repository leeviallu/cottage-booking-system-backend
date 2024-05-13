package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.Area;
import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.example.cottagebookingsystembackend.model.ServicesOfReservation;
import org.example.cottagebookingsystembackend.service.ServiceService;
import org.example.cottagebookingsystembackend.service.ServicesOfReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sor")

public class ServicesOfReservationController {

    private final ServicesOfReservationService servicesOfReservationService;

    @Autowired
    public ServicesOfReservationController(ServicesOfReservationService servicesOfReservationService) {
        this.servicesOfReservationService = servicesOfReservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ServicesOfReservation>> getServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(servicesOfReservationService.getSorByReservationId(id));
    }

    @PostMapping
    public ResponseEntity<String> createService(@RequestBody ServicesOfReservation servicesOfReservation) {
        if (servicesOfReservation.getServiceId() == null || servicesOfReservation.getReservationId() == null) {
            return ResponseEntity.badRequest().body("Required fields are missing.");
        }

        servicesOfReservationService.createSor(servicesOfReservation);
        return ResponseEntity.ok("Services Of Reservation has been created");
    }
}