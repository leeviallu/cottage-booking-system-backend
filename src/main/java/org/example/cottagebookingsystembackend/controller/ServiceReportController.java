package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.ServiceModel;
import org.example.cottagebookingsystembackend.service.ServiceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/services/report")
public class ServiceReportController {

    private final ServiceReportService serviceReportService;

    @Autowired
    public ServiceReportController(ServiceReportService serviceReportService) {
        this.serviceReportService = serviceReportService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<ServiceModel>
    getReportByName(@PathVariable String name) {
        System.out.println("Requested service name: " + name);
        Optional<ServiceModel> serviceModel = serviceReportService.findByName(name);
        return serviceModel
                .map(service -> ResponseEntity.ok().body(service))
                .orElse(ResponseEntity.notFound().build());
    }
}
