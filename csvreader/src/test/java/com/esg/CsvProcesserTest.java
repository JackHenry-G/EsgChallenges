package com.esg;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CsvProcesserTest {

    @Test
    public void testConvertToJson() {
        Customer customer1 = new Customer("1234", "Jack Goggin", "London", "Havering", "Hornchurch", "Essex", "England",
                "XYZ");
        Customer customer2 = new Customer("4321", "Jack Goggin", "London", "Havering", "Hornchurch", "Essex", "England",
                "XYZ");
        List<Customer> customerDetails = Arrays.asList(customer1, customer2);

        String expectedJson = "[{\"customerRef\":\"1234\",\"customerName\":\"Jack Goggin\",\"addressLineOne\":\"London\",\"addressLineTwo\":\"Havering\",\"town\":\"Hornchurch\",\"county\":\"Essex\",\"country\":\"England\",\"postcode\":\"XYZ\"},{\"customerRef\":\"4321\",\"customerName\":\"Jack Goggin\",\"addressLineOne\":\"London\",\"addressLineTwo\":\"Havering\",\"town\":\"Hornchurch\",\"county\":\"Essex\",\"country\":\"England\",\"postcode\":\"XYZ\"}]";

        CsvProcessor<Customer> csvProcessor = new CsvProcessor<Customer>();

        assertEquals(expectedJson, csvProcessor.convertToJson(customerDetails));
    }
}
