package org.example.cottagebookingsystembackend.controller;
import org.example.cottagebookingsystembackend.model.Area;
import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.example.cottagebookingsystembackend.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")

public class ServiceController {

   private final ServiceService serviceService;


    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/{id}")
    public ServiceModel getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }

    @GetMapping
    public List<ServiceModel> getAllServices(){
        return serviceService.getAllServices();
    }

    @PostMapping
    public ResponseEntity<String> createService(@RequestBody ServiceModel serviceModel) {
        if (serviceModel.getServiceId() == null || serviceModel.getArea().getAreaId() == null) {
            return ResponseEntity.badRequest().body("Required fields are missing.");
        }

        Area area = new Area();
        area.setAreaId(serviceModel.getArea().getAreaId());
        serviceModel.setArea(area);

        serviceService.createService(serviceModel);
        return ResponseEntity.ok("Service has been created");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateService(@PathVariable Long id, @RequestBody ServiceModel serviceModel) {
        ServiceModel existingService = serviceService.getServiceById(id);
        if (existingService != null) {
            serviceModel.setServiceId(id);
            if (serviceModel.getServiceId() == null || serviceModel.getArea().getAreaId() == null) {
                return ResponseEntity.badRequest().body("Required fields are missing.");
            }

            Area area = new Area();
            area.setAreaId(serviceModel.getArea().getAreaId());
            serviceModel.setArea(area);

            serviceService.updateService(serviceModel);
            return ResponseEntity.ok("Service updated successfully");
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Long id) {
        ServiceModel existingService = serviceService.getServiceById(id);
        if (existingService != null) {
            serviceService.deleteService(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
