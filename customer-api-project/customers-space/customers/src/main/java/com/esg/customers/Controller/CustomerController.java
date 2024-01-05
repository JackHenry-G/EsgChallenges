package com.esg.customers.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esg.customers.Model.Customer;
import com.esg.customers.Service.CustomerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();

        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(customers);
        }
    }

    @GetMapping("/customers/{customerRef}")
    public ResponseEntity<Customer> getCustomerByRef(@PathVariable String customerRef) {
        Optional<Customer> customer = customerService.getCustomerByRef(customerRef);

        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<List<Customer>> saveCustomers(@RequestBody List<Customer> customerDetails) {
        List<Customer> customers = customerService.saveAllCustomers(customerDetails);

        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(customers);
        }
    }

}
