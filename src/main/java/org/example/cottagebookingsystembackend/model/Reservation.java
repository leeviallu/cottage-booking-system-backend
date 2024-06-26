package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "varaus")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "varaus_id")
    private Long reservationId;

    @Column(name = "varattu_pvm")
    private Date reservationDate;

    @Column(name = "vahvistus_pvm")
    private Date confirmationDate;

    @Column(name = "varattu_alkupvm")
    private Date reservationStartingDate;

    @Column(name = "varattu_loppupvm")
    private Date reservationEndingDate;

    @ManyToOne
    @JoinColumn(name = "asiakas_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "mokki_id")
    private Cottage cottage;

    public  Reservation() {}

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Date getReservationStartingDate() {
        return reservationStartingDate;
    }

    public void setReservationStartingDate(Date reservationStartingDate) {
        this.reservationStartingDate = reservationStartingDate;
    }

    public Date getReservationEndingDate() {
        return reservationEndingDate;
    }

    public void setReservationEndingDate(Date reservationEndingDate) {
        this.reservationEndingDate = reservationEndingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cottage getCottage() {
        return cottage;
    }

    public void setCottage(Cottage cottage) {
        this.cottage = cottage;
    }
}
