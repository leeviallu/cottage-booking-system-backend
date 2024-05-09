package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Area;
import org.example.cottagebookingsystembackend.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {
    private final AreaRepository areaRepository;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public Area getAreaById(Long id) {
        Optional<Area> optionalArea = areaRepository.findById(id);
        return optionalArea.orElse(null);
    }

    @Override
    public void createArea(Area area) {
        areaRepository.save(area);
    }

    @Override
    public void updateArea(Area area) {
        areaRepository.save(area);
    }

    @Override
    public void deleteArea(Long id) {
        areaRepository.deleteSorReservationByAreaId(id);
        areaRepository.deleteSorServiceByAreaId(id);
        areaRepository.deleteBillingByAreaId(id);
        areaRepository.deleteServiceByAreaId(id);
        areaRepository.deleteReservationsByAreaId(id);
        areaRepository.deleteCottagesByAreaId(id);
        areaRepository.deleteById(id);
    }

    public List<Area> getAllAreas() {
        return (List<Area>) areaRepository.findAll();
    }
}