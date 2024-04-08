package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "varaus")

public class HousingReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long varaus_id;
    private Long asiakas_id;
    private Long mokki_id;
    private Date varattu_pvm;
    private Date vahvistus_pvm;
    private Date varattu_alkupvm;
    private Date varattu_loppupvm;

    public  HousingReservation() {}

    public Long getReservationId() {
        return varaus_id;
    }

    public void setReservationId(Long varaus_id) {
        this.varaus_id = varaus_id;
    }

    public Long getCustomerId() {
        return asiakas_id;
    }

    public void setCustomerId(Long asiakas_id) {
        this.asiakas_id = asiakas_id;
    }

    public Long getCottageId() {
        return mokki_id;
    }

    public void setCottageId(Long mokki_id) {
        this.mokki_id = mokki_id;
    }

    public Date getReservationDate() {
        return varattu_pvm;
    }

    public void setReservationDate(Date varattu_pvm) {
        this.varattu_pvm = varattu_pvm;
    }

    public Date getConfirmationDate() {
        return vahvistus_pvm;
    }

    public void setConfirmationDate(Date vahvistus_pvm) {
        this.vahvistus_pvm = vahvistus_pvm;
    }

    public Date getReservationStartDate() {
        return varattu_alkupvm;
    }

    public void setReservationStartDate(Date varattu_alkupvm) {
        this.varattu_alkupvm = varattu_alkupvm;
    }

    public Date getReservationEndDate() {
        return varattu_loppupvm;
    }

    public void setReservationEndDate(Date varattu_loppupvm) {
        this.varattu_loppupvm = varattu_loppupvm;
    }

}
