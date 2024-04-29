package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.Postal;
import org.example.cottagebookingsystembackend.service.PostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postal")
public class PostalController {
    private final PostalService postalService;

    @Autowired
    public PostalController(PostalService postalService) {
        this.postalService = postalService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Postal> getPostalByCode(@PathVariable Long code) {
        return ResponseEntity.ok(postalService.getPostalByCode(code));
    }

    @PostMapping
    public ResponseEntity<String> createPostal(@RequestBody Postal postal) {
        if (postal.getPostalcode() == null || postal.getPosition().isEmpty()) {
            return ResponseEntity.badRequest().body("Required fields are missing.");
        }
        postalService.createPostal(postal);
        return ResponseEntity.ok("Postal has been created");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deletePostal(@PathVariable Long code) {
        Postal existingPostal = postalService.getPostalByCode(code);
        if (existingPostal != null) {
            postalService.deletePostalByCode(code);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
