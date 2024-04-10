package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asiakas")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int asiakasId;
    private String postinro;
    private String etunimi;
    private String sukunimi;
    private String lahiosoite;
    private String email;
    private String puhelinnro;




    public Customer() {}

    public int getCustomerId() {
        return asiakasId;
    }

    public void setCustomerId(int asiakasId) {
        this.asiakasId = asiakasId;
    }

    public String getName() {
        return etunimi;
    }

    public void setName(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getPostalCode() {
        return postinro;
    }

    public void setPostalCode(String postinro) {
        this.postinro = postinro;
    }

    public String getLastName() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getLahiosoite() {
        return lahiosoite;
    }

    public void setLahiosoite(String lahiosoite) {
        this.lahiosoite = lahiosoite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuhelinnro() {
        return puhelinnro;
    }

    public void setPuhelinnro(String puhelinnro) {
        this.puhelinnro = puhelinnro;
    }
}



