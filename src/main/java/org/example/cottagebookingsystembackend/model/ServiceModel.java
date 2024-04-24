package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;
@Entity
@Table(name = "palvelu")
public class ServiceModel {
    @Id
    @Column(name = "palvelu_id")
    private Long serviceId;

    @Column(name = "nimi")
    private String name;

    @Column(name = "kuvaus")
    private String description;

    @Column(name = "hinta")
    private Double price;

    @Column(name = "alv")
    private Double vat;

    @ManyToOne
    @JoinColumn(name = "alue_id")
    private Area area;

    public ServiceModel() {
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}