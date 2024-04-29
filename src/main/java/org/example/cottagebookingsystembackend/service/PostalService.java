package org.example.cottagebookingsystembackend.service;

import org.example.cottagebookingsystembackend.model.Postal;

public interface PostalService {
    Postal getPostalByCode(long code);
    void createPostal(Postal postal);
    void deletePostalByCode(long code);
}
