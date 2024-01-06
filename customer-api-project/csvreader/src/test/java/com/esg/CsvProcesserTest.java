package com.esg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class CsvProcesserTest {

    private CsvProcessor<Customer> csvProcessor;

    @BeforeEach
    public void BeforeAll() {
        csvProcessor = new CsvProcessor<Customer>();
    }

    @Test
    public void testParseCsvToJsonWithEmptyCsv() throws FileNotFoundException {
        String expectedJson = "[]";

        String actualJson = csvProcessor
                .parseCsvToJson("src/test/resources/noCustomers.csv", Customer.class);

        assertEquals(expectedJson, actualJson, "Empty CSV returned no JSON");
    }

    @Test
    public void testParseCsvToJsonWithOneCustomerCsv() throws FileNotFoundException {
        String expectedJson = "[{\"customerRef\":\"CUST001\",\"customerName\":\" John Smith\",\"addressLineOne\":\" 123 Oak Street\",\"addressLineTwo\":\" Suite 100\",\"town\":\" Springfield\",\"county\":\" Greene\",\"country\":\" USA\",\"postcode\":\" 65804\"}]";

        String actualJson = csvProcessor
                .parseCsvToJson("src/test/resources/oneCustomer.csv", Customer.class);

        assertEquals(expectedJson, actualJson, "Empty CSV returned no JSON");
    }

    @Test
    public void testParseCsvToJsonWithManyCustomersCsv() throws FileNotFoundException {
        String expectedJson = "[{\"customerRef\":\"CUST001\",\"customerName\":\" John Smith\",\"addressLineOne\":\" 123 Oak Street\",\"addressLineTwo\":\" Suite 100\",\"town\":\" Springfield\",\"county\":\" Greene\",\"country\":\" USA\",\"postcode\":\" 65804\"},{\"customerRef\":\"CUST002\",\"customerName\":\" Jane Doe\",\"addressLineOne\":\" 456 Maple Avenue\",\"addressLineTwo\":\" Suite 200\",\"town\":\" Lakeside\",\"county\":\" Lake County\",\"country\":\" USA\",\"postcode\":\" 60073\"}]";

        String actualJson = csvProcessor
                .parseCsvToJson("src/test/resources/manyCustomers.csv", Customer.class);

        assertEquals(expectedJson, actualJson, "Empty CSV returned no JSON");
    }

    @Test
    public void testConvertToJson() {
        Customer customer1 = new Customer("1234", "Jack Goggin", "London", "Havering", "Hornchurch", "Essex", "England",
                "XYZ");
        Customer customer2 = new Customer("4321", "Jack Goggin", "London", "Havering", "Hornchurch", "Essex", "England",
                "XYZ");
        List<Customer> customerDetails = Arrays.asList(customer1, customer2);

        String expectedJson = "[{\"customerRef\":\"1234\",\"customerName\":\"Jack Goggin\",\"addressLineOne\":\"London\",\"addressLineTwo\":\"Havering\",\"town\":\"Hornchurch\",\"county\":\"Essex\",\"country\":\"England\",\"postcode\":\"XYZ\"},{\"customerRef\":\"4321\",\"customerName\":\"Jack Goggin\",\"addressLineOne\":\"London\",\"addressLineTwo\":\"Havering\",\"town\":\"Hornchurch\",\"county\":\"Essex\",\"country\":\"England\",\"postcode\":\"XYZ\"}]";

        CsvProcessor<Customer> csvProcessor = new CsvProcessor<Customer>();

        assertEquals(expectedJson, csvProcessor.convertToJson(customerDetails), "Customers JSON received succesfullly");
    }
}
