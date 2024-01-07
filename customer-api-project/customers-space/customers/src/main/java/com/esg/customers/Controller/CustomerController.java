package com.esg.customers.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esg.customers.Model.Customer;
import com.esg.customers.Service.CustomerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Retrieves all customers from the database.
     * 
     * @return ResponseEntity<List<Customer>> - a list of JSON customer objects.
     */
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();

        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(customers);
        }
    }

    /**
     * Allows clients to save a list of customer records into the database.
     * 
     * @param customerDetails - json data following the specified customer object.
     * @return ResponseEntity<List<Customer>> - the list of newly created customers.
     */
    @PostMapping
    public ResponseEntity<List<Customer>> saveCustomers(@RequestBody List<Customer> customerDetails) {
        List<Customer> customers = customerService.saveAllCustomers(customerDetails);

        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(customers);
        }
    }

    /**
     * Gets the one, unqiue, specified custoemr object by the reference number.
     * 
     * @param customerRef - unique ID for the customer.
     * @return ResponseEntity<Customer> - one single customer JSON object.
     */
    @GetMapping("/{customerRef}")
    public ResponseEntity<Customer> getCustomerByRef(@PathVariable String customerRef) {
        Optional<Customer> customer = customerService.getCustomerByRef(customerRef);

        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
