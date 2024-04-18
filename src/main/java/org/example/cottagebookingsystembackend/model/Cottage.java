package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mokki")
public class Cottage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mokki_id")
    private Long cottageId;
    @ManyToOne
    @JoinColumn(name = "alue_id")
    private Area area;
    @ManyToOne
    @JoinColumn(name = "postinro")
    private Postal postal;
    @Column(name = "mokkinimi")
    private String name;
    @Column(name = "katuosoite")
    private String address;
    @Column(name = "hinta")
    private double price;
    @Column(name = "kuvaus")
    private String description;
    @Column(name = "henkilomaara")
    private int capacity;
    @Column(name = "varustelu")
    private String equipment;

    public Cottage() {}


    public Long getCottageId() {
        return cottageId;
    }

    public void setCottageId(Long cottageId) {
        this.cottageId = cottageId;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Postal getPostal() {
        return postal;
    }

    public void setPostal(Postal postal) {
        this.postal = postal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
