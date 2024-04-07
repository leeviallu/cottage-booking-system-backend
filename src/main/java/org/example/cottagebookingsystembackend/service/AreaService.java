package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Area;

import java.util.List;

public interface AreaService {
    Area getAreaById(Long id);
    void createArea(Area area);
    void updateArea(Area area);
    void deleteArea(Long id);
    List<Area> getAllAreas();
}