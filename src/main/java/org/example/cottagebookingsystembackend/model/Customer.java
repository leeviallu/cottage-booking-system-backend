package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asiakas")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asiakasId;
    private String postinro;
    private String etunimi;
    private String sukunimi;
    private String lahiosoite;
    private String email;
    private String puhelinnro;




    public Customer() {}

    public Long getCustomerId() {
        return asiakasId;
    }

    public void setCustomerId(long asiakasId) {
        this.asiakasId = asiakasId;
    }

    public String getFirstName() {
        return etunimi;
    }

    public void setFirstName(String etunimi) {
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

    public void setLastName(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getAddress() {
        return lahiosoite;
    }

    public void setAddress(String lahiosoite) {
        this.lahiosoite = lahiosoite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return puhelinnro;
    }

    public void setPhoneNumber(String puhelinnro) {
        this.puhelinnro = puhelinnro;
    }
}



