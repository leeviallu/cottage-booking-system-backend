package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;
@Entity
@Table(name = "palvelu")
public class ServiceModel {
    @Id
    private Long palvelu_Id;
    private Long alueId;
    private String nimi;
    private int tyyppi;
    private String kuvaus;
    private double hinta;
    private double alv;

    public ServiceModel(){}

    public Long getServiceId() {
        return palvelu_Id;
    }

    public void setServiceId(Long palvelu_Id) {
        this.palvelu_Id = palvelu_Id;
    }

    public Long getAreaId() {
        return alueId;
    }

    public void setAreaId(Long alueId) {
        this.alueId = alueId;
    }

    public String getName() {
        return nimi;
    }

    public void setName(String nimi) {
        this.nimi = nimi;
    }

    public int getType() {
        return tyyppi;
    }

    public void setType(int tyyppi) {
        this.tyyppi = tyyppi;
    }

    public String getDescription() {
        return kuvaus;
    }

    public void setDescription(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public double getPrice() {
        return hinta;
    }

    public void setPrice(double hinta) {
        this.hinta = hinta;
    }

    public double getVat() {
        return alv;
    }

    public void setVat(double alv) {
        this.alv = alv;
    }



}
