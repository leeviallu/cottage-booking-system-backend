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

    public Long getMokkiId() {
        return mokkiId;
    }

    public void setMokkiId(Long mokkiId) {
        this.mokkiId = mokkiId;
    }

    public Long getAlueId() {
        return alueId;
    }

    public void setAlueId(Long alueId) {
        this.alueId = alueId;
    }

    public String getPostinro() {
        return postinro;
    }

    public void setPostinro(String postinro) {
        this.postinro = postinro;
    }

    public String getMokkinimi() {
        return mokkinimi;
    }

    public void setMokkinimi(String mokkinimi) {
        this.mokkinimi = mokkinimi;
    }

    public String getKatuosoite() {
        return katuosoite;
    }

    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }

    public double getHinta() {
        return hinta;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public int getHenkilomaara() {
        return henkilomaara;
    }

    public void setHenkilomaara(int henkilomaara) {
        this.henkilomaara = henkilomaara;
    }

    public String getVarustelu() {
        return varustelu;
    }

    public void setVarustelu(String varustelu) {
        this.varustelu = varustelu;
    }
}
