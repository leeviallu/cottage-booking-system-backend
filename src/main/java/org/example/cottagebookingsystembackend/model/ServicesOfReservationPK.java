package org.example.cottagebookingsystembackend.model;

import java.io.Serializable;
import java.util.Objects;

public class ServicesOfReservationPK implements Serializable {
    private Long serviceId;
    private Long reservationId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicesOfReservationPK that = (ServicesOfReservationPK) o;
        return Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, reservationId);
    }
}
