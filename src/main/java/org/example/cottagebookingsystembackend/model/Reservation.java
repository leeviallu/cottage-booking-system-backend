package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "varaus")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long varausId;
    private Long asiakasId;
    private Long mokkiMokkiId;
    private Date varattuPvm;
    private Date vahvistusPvm;
    private Date varattuAlkupvm;
    private Date varattuLoppupvm;

    public  Reservation() {}

    public Long getReservationId() {
        return varausId;
    }

    public void setReservationId(Long varausId) {
        this.varausId = varausId;
    }

    public Long getCustomerId() {
        return asiakasId;
    }

    public void setCustomerId(Long asiakasId) {
        this.asiakasId = asiakasId;
    }

    public Long getCottageId() {
        return mokkiMokkiId;
    }

    public void setCottageId(Long mokkiMokkiId) {
        this.mokkiMokkiId = mokkiMokkiId;
    }

    public Date getReservationDate() {
        return varattuPvm;
    }

    public void setReservationDate(Date varattuPvm) {
        this.varattuPvm = varattuPvm;
    }

    public Date getConfirmationDate() {
        return vahvistusPvm;
    }

    public void setConfirmationDate(Date vahvistusPvm) {
        this.vahvistusPvm = vahvistusPvm;
    }

    public Date getReservationStartDate() {
        return varattuAlkupvm;
    }

    public void setReservationStartDate(Date varattuAlkupvm) {
        this.varattuAlkupvm = varattuAlkupvm;
    }

    public Date getReservationEndDate() {
        return varattuLoppupvm;
    }

    public void setReservationEndDate(Date varattuLoppupvm) {
        this.varattuLoppupvm = varattuLoppupvm;
    }

}
