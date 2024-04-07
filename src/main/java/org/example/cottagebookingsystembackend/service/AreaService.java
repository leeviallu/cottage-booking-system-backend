package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Area;

import java.util.List;

public interface AreaService {
    Area getAreaById(Long id);
    void createArea(Area product);
    void updateArea(Area product);
    void deleteArea(Long id);
    List<Area> getAllAreas();
}