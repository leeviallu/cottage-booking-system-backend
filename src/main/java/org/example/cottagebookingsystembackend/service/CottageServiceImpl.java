package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Cottage;
import org.example.cottagebookingsystembackend.repository.CottageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CottageServiceImpl implements CottageService {
    private final CottageRepository cottageRepository;

    @Autowired
    public CottageServiceImpl(CottageRepository cottageRepository) {
        this.cottageRepository = cottageRepository;
    }

    @Override
    public Cottage getCottageById(Long id) {
        Optional<Cottage> optionalCottage = cottageRepository.findById(id);
        return optionalCottage.orElse(null);
    }

    @Override
    public void createCottage(Cottage cottage) {
        cottageRepository.save(cottage);
    }

    @Override
    public void updateCottage(Cottage cottage) {
        cottageRepository.save(cottage);
    }

    @Override
    public void deleteCottage(Long id) {
        cottageRepository.deleteBillingByCottageId(id);
        cottageRepository.deleteSorByCottageId(id);
        cottageRepository.deleteReservationsByCottageId(id);
        cottageRepository.deleteById(id);
    }

    public List<Cottage> getAllCottages() {
        return (List<Cottage>) cottageRepository.findAll();
    }

    public List<Cottage> getAllCottagesByAreaId(Long areaId) {
        return (List<Cottage>) cottageRepository.findAllCottagesByAreaId(areaId);
    }

}