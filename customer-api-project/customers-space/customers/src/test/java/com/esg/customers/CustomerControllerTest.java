package com.esg.customers;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.esg.customers.Controller.CustomerController;
import com.esg.customers.Model.Customer;
import com.esg.customers.Service.CustomerService;

@WebMvcTest(CustomerController.class) // focus on controller class
public class CustomerControllerTest {

    @MockBean // populate a mock of customerService
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc; // enables us to send & validate HTTP requests

    @Test
    void shouldGetNoContentResponseWhenNoCustomersExists() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customers"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void shouldGetJsonApproachResponseWhenCustomersExist() throws Exception {
        Customer customer1 = new Customer("1234", "Jack Goggin", "London", "Havering", "Hornchurch", "Essex", "England",
                "XYZ");
        Customer customer2 = new Customer("4321", "Jack Goggin", "London", "Havering", "Hornchurch", "Essex", "England",
                "XYZ");
        List<Customer> customerDetails = Arrays.asList(customer1, customer2);
        when(customerService.getAllCustomers()).thenReturn(customerDetails);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
