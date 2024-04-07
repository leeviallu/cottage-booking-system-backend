package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mokki")
public class Cottage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mokkiId;
    private Long alueId;
    private String postinro;
    private String mokkinimi;
    private String katuosoite;
    private double hinta;
    private String kuvaus;
    private int henkilomaara;
    private String varustelu;

    public Cottage() {}

    public Long getCottageId() {
        return mokkiId;
    }

    public void setCottageId(Long mokkiId) {
        this.mokkiId = mokkiId;
    }

    public Long getAreaId() {
        return alueId;
    }

    public void setAreaId(Long alueId) {
        this.alueId = alueId;
    }

    public String getPostalCode() {
        return postinro;
    }

    public void setPostalCode(String postinro) {
        this.postinro = postinro;
    }

    public String getCottageName() {
        return mokkinimi;
    }

    public void setCottageName(String mokkinimi) {
        this.mokkinimi = mokkinimi;
    }

    public String getAddress() {
        return katuosoite;
    }

    public void setAddress(String katuosoite) {
        this.katuosoite = katuosoite;
    }

    public double getPrice() {
        return hinta;
    }

    public void setPrice(double hinta) {
        this.hinta = hinta;
    }

    public String getDescription() {
        return kuvaus;
    }

    public void setDescription(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public int getPersonCapacity() {
        return henkilomaara;
    }

    public void setPersonCapacity(int henkilomaara) {
        this.henkilomaara = henkilomaara;
    }

    public String getEquipment() {
        return varustelu;
    }

    public void setEquipment(String varustelu) {
        this.varustelu = varustelu;
    }
}
