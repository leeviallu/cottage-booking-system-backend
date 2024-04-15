package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.Cottage;
import org.example.cottagebookingsystembackend.service.CottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cottages")
public class CottageController {
    private final CottageService cottageService;

    @Autowired
    public CottageController(CottageService cottageService) {
        this.cottageService = cottageService;
    }

    @GetMapping("/{id}")
    public Cottage getCottageById(@PathVariable Long id) {
        return cottageService.getCottageById(id);
    }

    @GetMapping
    public List<Cottage> getAllCottages() {
        return cottageService.getAllCottages();
    }

    @PostMapping
    public ResponseEntity<String> createCottage(@RequestBody Cottage cottage) {
        if (cottage.getArea() == null || cottage.getPostalcode() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        cottageService.createCottage(cottage);
        return ResponseEntity.ok("Cottage has been created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCottage(@PathVariable Long id, @RequestBody Cottage cottage) {
        Cottage existingCottage = cottageService.getCottageById(id);
        if (existingCottage != null) {
            cottage.setCottageId(id);
            if (cottage.getCottageId() == null || cottage.getArea() == null || cottage.getPostalcode() == null) {
                return ResponseEntity.unprocessableEntity().build();
            }
            cottageService.updateCottage(cottage);
            return ResponseEntity.ok("Cottage updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCottage(@PathVariable Long id) {
        Cottage existingCottage = cottageService.getCottageById(id);
        if (existingCottage != null) {
            cottageService.deleteCottage(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
