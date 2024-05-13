package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

@Entity
@IdClass(ServicesOfReservationPK.class)
@Table(name = "varauksen_palvelut")
public class ServicesOfReservation {
    @Id
    private Long serviceId;

    @Id
    private Long reservationId;

    @Column(name = "lkm")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}