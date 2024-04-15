package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asiakas")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asiakas_id")
    private Long customer;
    @ManyToOne
    @JoinColumn(name = "postinro")
    private Postal postalcode;
    @Column(name = "etunimi")
    private String firstname;
    @Column(name = "sukunimi")
    private String lastname;
    @Column(name = "lahiosoite")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "puhelinnro")
    private String phonenumber;

    public Customer() {}

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Postal getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Postal postalcode) {
        this.postalcode = postalcode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}



