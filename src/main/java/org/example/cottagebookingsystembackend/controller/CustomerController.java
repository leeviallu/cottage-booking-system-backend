package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.Customer;
import org.example.cottagebookingsystembackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerController customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        if (customer.getPostalCode() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        customerService.createCustomer(customer);
        return ResponseEntity.ok("Customer has been created");
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCottage(@PathVariable Long id, @RequestBody Cottage cottage) {
        Cottage existingCottage = cottageService.getCottageById(id);
        if (existingCottage != null) {
            cottage.setCottageId(id);
            if (cottage.getCottageId() == null || cottage.getAreaId() == null || cottage.getPostalCode() == null) {
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

*/

}

