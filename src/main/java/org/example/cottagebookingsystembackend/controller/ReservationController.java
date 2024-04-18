package org.example.cottagebookingsystembackend.controller;


import org.example.cottagebookingsystembackend.model.Reservation;
import org.example.cottagebookingsystembackend.model.ServicesOfReservation;
import org.example.cottagebookingsystembackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getHousingReservationById(@PathVariable Long id) {
        return ResponseEntity.ok().body(reservationService.getReservationById(id));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllHousingReservations() {
        return ResponseEntity.ok().body(reservationService.getAllReservations());
    }

    @GetMapping("/cottages")
    public ResponseEntity<List<ServicesOfReservation>> getCottageReservationsByDate(@RequestParam String startDate, @RequestParam String endDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startFormatted = inputFormat.parse(startDate);
            Date endFormatted = inputFormat.parse(endDate);
            return ResponseEntity.ok().body(reservationService.getAllServiceReservationsByDate(startFormatted, endFormatted));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/services")
    public ResponseEntity<List<Reservation>> getServiceReservationsByDate(@RequestParam String startDate, @RequestParam String endDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startFormatted = inputFormat.parse(startDate);
            Date endFormatted = inputFormat.parse(endDate);
            return ResponseEntity.ok().body(reservationService.getAllCottageReservationsByDate(startFormatted, endFormatted));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<String> createHousingReservation(@RequestBody Reservation reservation) {
        if (reservation.getCustomerId() == null || reservation.getCottageId() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        reservationService.createReservation(reservation);
        return ResponseEntity.ok("Reservation has been created.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateHousingReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        Reservation existingHousingReservation = reservationService.getReservationById(id);
        if (existingHousingReservation != null) {
            reservation.setReservationId(id);
            if (reservation.getReservationId() == null || reservation.getCustomerId() == null || reservation.getCottageId() == null) {
                return ResponseEntity.unprocessableEntity().build();
            }
            reservationService.updateReservation(reservation);
            return ResponseEntity.ok("Reservation updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHousingReservation(@PathVariable Long id) {
        Reservation existingHousingReservation = reservationService.getReservationById(id);
        if (existingHousingReservation != null) {
            reservationService.deleteReservation(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
