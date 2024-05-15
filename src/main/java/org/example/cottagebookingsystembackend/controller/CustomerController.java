package org.example.cottagebookingsystembackend.controller;

import org.example.cottagebookingsystembackend.model.Customer;
import org.example.cottagebookingsystembackend.model.Postal;
import org.example.cottagebookingsystembackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Customer> getCustomerByEmail(@RequestParam String email) {
        return ResponseEntity.ok(customerService.getCustomerByEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }


    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        if (customer.getPostal().getPostalcode() == null) {
            return ResponseEntity.badRequest().body("Required fields are missing.");
        }

        Postal postal = new Postal();
        postal.setPostalcode(customer.getPostal().getPostalcode());
        customer.setPostal(postal);

        customerService.createCustomer(customer);
        return ResponseEntity.ok("Customer has been created");
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer != null) {
            customer.setCustomerId(id);

            if (customer.getCustomerId() == null || customer.getPostal().getPostalcode() == null) {
                return ResponseEntity.badRequest().body("Required fields are missing.");
            }

            Postal postal = new Postal();
            postal.setPostalcode(customer.getPostal().getPostalcode());
            customer.setPostal(postal);

            customerService.updateCustomer(customer);
            return ResponseEntity.ok("Customer updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer != null) {
            customerService.deleteCustomer(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

