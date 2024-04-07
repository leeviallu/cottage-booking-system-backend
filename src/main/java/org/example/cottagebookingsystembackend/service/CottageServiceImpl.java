package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Area;
import org.example.cottagebookingsystembackend.model.Cottage;
import org.example.cottagebookingsystembackend.repository.AreaRepository;
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
        cottageRepository.deleteById(id);
    }

    public List<Cottage> getAllCottages() {
        return cottageRepository.findAll();
    }
}