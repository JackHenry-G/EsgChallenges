package com.esg.customers.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esg.customers.Model.Customer;
import com.esg.customers.Repository.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByRef(String customerRef) {
        return customerRepository.findById(customerRef);
    }

    public List<Customer> saveAllCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

}
