package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lasku")
public class Billing {
    @Id
    @Column(name = "lasku_id")
    private Long billingId;
    @Column(name = "varaus_id")
    private Long reservationId;
    @Column(name = "summa")
    private double sum;
    @Column(name = "alv")
    private double VAT;
    @Column(name = "maksettu")
    private Boolean isPaid;

    public Billing() {}

    public Long getBillingId(){
        return billingId;
    }

    public void setBillingId(Long billingId) {
        this.billingId = billingId;
    }

    public Long getReservationId(){
        return reservationId;
    }

    public void  setReservationId(Long reservationId){
        this.reservationId = reservationId;
    }

    public double getSum(){
        return sum;
    }

    public void setSum(double sum){
        this.sum = sum;
    }

    public double getVAT(){
        return VAT;
    }

    public void setVAT(double VAT){
        this.VAT = VAT;
    }

    public Boolean getIsPaid(){
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid){
        this.isPaid = isPaid;
    }
}