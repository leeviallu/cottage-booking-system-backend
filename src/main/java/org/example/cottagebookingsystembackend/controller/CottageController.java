package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.Area;
import org.example.cottagebookingsystembackend.model.Cottage;
import org.example.cottagebookingsystembackend.service.AreaService;
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
    public List<Cottage> getAllAreas() {
        return cottageService.getAllCottages();
    }

    @PostMapping
    public ResponseEntity<String> createCottage(@RequestBody Cottage cottage) {
        /*
        if (area.getName() == null || area.getName().isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
         */
        cottageService.createCottage(cottage);
        return ResponseEntity.ok("Cottage has been created");
    }
    /*




    @PutMapping("/{id}")
    public ResponseEntity<String> updateArea(@PathVariable Long id, @RequestBody Area area) {
        Area existingArea = areaService.getAreaById(id);
        if (existingArea != null) {
            area.setAreaId(id);
            areaService.updateArea(area);
            return ResponseEntity.ok("Area updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArea(@PathVariable Long id) {
        Area existingArea = areaService.getAreaById(id);
        if (existingArea != null) {
            areaService.deleteArea(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
     */
}
