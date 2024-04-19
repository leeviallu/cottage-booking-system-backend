package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.Area;
import org.example.cottagebookingsystembackend.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable Long id) {
        return ResponseEntity.ok(areaService.getAreaById(id));
    }

    @GetMapping
    public ResponseEntity<List<Area>> getAllAreas() {
        return ResponseEntity.ok(areaService.getAllAreas());
    }

    @PostMapping
    public ResponseEntity<String> createArea(@RequestBody Area area) {
        if (area.getName() == null || area.getName().isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        areaService.createArea(area);
        return ResponseEntity.ok("Area has been created");
    }

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
}