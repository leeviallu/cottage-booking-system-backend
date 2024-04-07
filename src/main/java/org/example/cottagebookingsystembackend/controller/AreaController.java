package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.Area;
import org.example.cottagebookingsystembackend.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Area getAreaById(@PathVariable Long id) {
        return areaService.getAreaById(id);
    }

    @GetMapping
    public List<Area> getAllAreas() {
        return areaService.getAllAreas();
    }

    @PostMapping
    public void createArea(@RequestBody Area area) {
        areaService.createArea(area);
    }

    @PutMapping("/{id}")
    public void updateArea(@PathVariable Long id, @RequestBody Area area) {
        Area existingArea = areaService.getAreaById(id);
        if (existingArea != null) {
            area.setAreaId(id); // Ensure the correct ID is set
            areaService.updateArea(area);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteArea(@PathVariable Long id) {
        areaService.deleteArea(id);
    }
}