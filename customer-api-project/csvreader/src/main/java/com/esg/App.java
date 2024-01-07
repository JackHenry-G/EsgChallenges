package com.esg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) {
        try {
            // get customer details as JSON from csv file
            CsvProcessor<Customer> csvProcessor = new CsvProcessor<Customer>();
            String customerDetails = csvProcessor.parseCsvToJson("csvreader/customer_details.csv", Customer.class);
            System.out.println("Customer details from CSV retrieved as: " + customerDetails);

            // POST them to rest endpoint
            String submitCustomerDetailsEndpoint = "http://localhost:8080/customers";
            RestProcessor restProcessor = new RestProcessor();
            HttpResponse<String> restResponse = restProcessor.makePostRequestWithJsonBody(submitCustomerDetailsEndpoint,
                    customerDetails);
            System.out.println("HTTP request processed - " + restResponse.toString());
        } catch (FileNotFoundException e) {
            System.err.println("Error - CSV not found: " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.err.println("Error - Network or interruption: " + e.getMessage());
        }
    }
}
