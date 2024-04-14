package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "varauksen_palvelut")
public class ServicesOfReservation {
    @Id
    @ManyToOne
    @JoinColumn(name = "varaus_id")
    private Reservation reservation;

    @Id
    @ManyToOne
    @JoinColumn(name = "palvelu_id")
    private ServiceModel service;

    @Column(name = "lkm")
    private Integer count;

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public ServiceModel getService() {
        return service;
    }

    public void setService(ServiceModel service) {
        this.service = service;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}