package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Postal;
import org.example.cottagebookingsystembackend.repository.PostalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostalServiceImpl implements PostalService {
    private final PostalRepository postalRepository;

    @Autowired
    public PostalServiceImpl(PostalRepository postalRepository) {
        this.postalRepository = postalRepository;
    }

    @Override
    public Postal getPostalByCode(long code) {
        Optional<Postal> optionalPostal= postalRepository.findById(code);
        return optionalPostal.orElse(null);
    }

    @Override
    public void createPostal(Postal postal) {
        postalRepository.save(postal);
    }

    @Override
    public void deletePostalByCode(long code) {
        postalRepository.deleteById(code);
    }
}
