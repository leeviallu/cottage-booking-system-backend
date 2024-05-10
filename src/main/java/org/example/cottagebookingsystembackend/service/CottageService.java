package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Cottage;

import java.util.List;

public interface CottageService {
    Cottage getCottageById(Long id);
    void createCottage(Cottage cottage);
    void updateCottage(Cottage cottage);
    void deleteCottage(Long id);
    List<Cottage> getAllCottages();
    List<Cottage> getAllCottagesByAreaId(Long areaId);
}