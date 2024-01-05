package com.esg.customers.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "customers")
@ToString
public class Customer {

    @Id
    private String customerRef;

    private String customerName;

    private String addressLineOne;

    private String addressLineTwo;

    private String town;

    private String county;

    private String country;

    private String postcode;

    public Customer() {
    }

    public Customer(String customerRef, String customerName, String addressLineOne, String addressLineTwo, String town,
            String county, String country, String postcode) {
        this.customerRef = customerRef;
        this.customerName = customerName;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.town = town;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}
