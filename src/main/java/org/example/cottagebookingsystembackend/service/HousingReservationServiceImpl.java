package org.example.cottagebookingsystembackend.service;


import org.example.cottagebookingsystembackend.model.HousingReservation;
import org.example.cottagebookingsystembackend.repository.HousingReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HousingReservationServiceImpl implements HousingReservationService{

    private final HousingReservationRepository housingReservationRepository;

    @Autowired
    public HousingReservationServiceImpl(HousingReservationRepository housingReservationRepository) {
        this.housingReservationRepository = housingReservationRepository;
    }

    @Override
    public HousingReservation getHousingReservationById(Long id) {
        Optional<HousingReservation> optionalHousingReservation = housingReservationRepository.findById(id);
        return optionalHousingReservation.orElse(null);
    }

    @Override
    public void createHousingReservation(HousingReservation housingReservation) {
        housingReservationRepository.save(housingReservation);
    }

    @Override
    public void updateHousingReservation(HousingReservation housingReservation) {
        housingReservationRepository.save(housingReservation);
    }

    @Override
    public void deleteHousingReservation(Long id) {
        housingReservationRepository.deleteById(id);
    }

    public List<HousingReservation> getAllHousingReservations() {
        return (List<HousingReservation>) housingReservationRepository.findAll();
    }
}