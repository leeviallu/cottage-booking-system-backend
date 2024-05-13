package org.example.cottagebookingsystembackend.controller;


import org.example.cottagebookingsystembackend.model.*;
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
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllHousingReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/cottages/{areaId}")
    public ResponseEntity<List<Reservation>> getCottageReservationsByDate(@PathVariable Long areaId, @RequestParam String startDate, @RequestParam String endDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startFormatted = inputFormat.parse(startDate);
            Date endFormatted = inputFormat.parse(endDate);
            return ResponseEntity.ok().body(reservationService.getAllCottageReservationsByDate(areaId, startFormatted, endFormatted));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/services/{areaId}")
    public ResponseEntity<List<Object[]>> getServiceReservationsByDate(@PathVariable Long areaId, @RequestParam String startDate, @RequestParam String endDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startFormatted = inputFormat.parse(startDate);
            Date endFormatted = inputFormat.parse(endDate);
            return ResponseEntity.ok().body(reservationService.getAllServiceReservationsByDate(areaId, startFormatted, endFormatted));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<String> createHousingReservation(@RequestBody Reservation reservation) {
        if (reservation.getCustomer().getCustomerId() == null || reservation.getCottage().getCottageId() == null) {
            return ResponseEntity.badRequest().body("Required fields are missing.");
        }

        Customer customer = new Customer();
        customer.setCustomerId(reservation.getCustomer().getCustomerId());
        reservation.setCustomer(customer);

        Cottage cottage = new Cottage();
        cottage.setCottageId(reservation.getCottage().getCottageId());
        reservation.setCottage(cottage);

        reservationService.createReservation(reservation);
        return ResponseEntity.ok("Reservation has been created.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateHousingReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        Reservation existingHousingReservation = reservationService.getReservationById(id);
        if (existingHousingReservation != null) {
            reservation.setReservationId(id);

            if (reservation.getReservationId() == null || reservation.getCustomer().getCustomerId() == null || reservation.getCottage().getCottageId() == null) {
                return ResponseEntity.badRequest().body("Required fields are missing.");
            }

            Customer customer = new Customer();
            customer.setCustomerId(reservation.getCustomer().getCustomerId());
            reservation.setCustomer(customer);

            Cottage cottage = new Cottage();
            cottage.setCottageId(reservation.getCottage().getCottageId());
            reservation.setCottage(cottage);

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
