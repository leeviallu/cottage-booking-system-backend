package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.HousingReservation;
import org.example.cottagebookingsystembackend.service.HousingReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/housing-reservations")
public class HousingReservationController {

    private final HousingReservationService housingReservationService;

    @Autowired
    public HousingReservationController(HousingReservationService housingReservationService) {
        this.housingReservationService = housingReservationService;
    }

    @GetMapping("/{id}")
    public HousingReservation getHousingReservationById(@PathVariable Long id) {
        return housingReservationService.getHousingReservationById(id);
    }

    @GetMapping
    public List<HousingReservation> getAllHousingReservations() {
        return housingReservationService.getAllHousingReservations();
    }

    @PostMapping
    public ResponseEntity<String> createHousingReservation(@RequestBody HousingReservation housingReservation) {
        System.out.println(housingReservation.getCustomerId() + " " + housingReservation.getCottageId());
        if (housingReservation.getCustomerId() == null || housingReservation.getCottageId() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        housingReservationService.createHousingReservation(housingReservation);
        return ResponseEntity.ok("Housing reservation has been created.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateHousingReservation(@PathVariable Long id, @RequestBody HousingReservation housingReservation) {
        HousingReservation existingHousingReservation = housingReservationService.getHousingReservationById(id);
        if (existingHousingReservation != null) {
            housingReservation.setReservationId(id);
            if (housingReservation.getReservationId() == null || housingReservation.getCustomerId() == null || housingReservation.getCottageId() == null) {
                return ResponseEntity.unprocessableEntity().build();
            }
            housingReservationService.updateHousingReservation(housingReservation);
            return ResponseEntity.ok("Reservation updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHousingReservation(@PathVariable Long id) {
        HousingReservation existingHousingReservation = housingReservationService.getHousingReservationById(id);
        if (existingHousingReservation != null) {
            housingReservationService.deleteHousingReservation(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
