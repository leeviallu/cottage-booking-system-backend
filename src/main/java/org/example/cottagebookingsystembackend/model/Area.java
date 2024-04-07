package org.example.cottagebookingsystembackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alue")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alueId;
    private String nimi;

    public Area() {}

    public Area(Long alueId, String nimi) {
        this.alueId = alueId;
        this.nimi = nimi;
    }

    public void setAreaId(Long alueId) {
        this.alueId = alueId;
    }

    public void setName(String nimi) {
        this.nimi = nimi;
    }

    public Long getAreaId() {
        return alueId;
    }

    public String getName() {
        return nimi;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + alueId +
                ", name='" + nimi + '\'' +
                '}';
    }
}
