package com.esg;

import com.opencsv.bean.CsvBindByPosition;

public class Customer {

    @CsvBindByPosition(position = 0)
    private String customerRef;

    @CsvBindByPosition(position = 1)
    private String customerName;

    @CsvBindByPosition(position = 2)
    private String addressLineOne;

    @CsvBindByPosition(position = 3)
    private String addressLineTwo;

    @CsvBindByPosition(position = 4)
    private String town;

    @CsvBindByPosition(position = 5)
    private String county;

    @CsvBindByPosition(position = 6)
    private String country;

    @CsvBindByPosition(position = 7)
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

    @Override
    public String toString() {
        return "Customer [customerRef=" + customerRef + ", customerName=" + customerName + ", addressLineOne="
                + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", town=" + town + ", county=" + county
                + ", country=" + country + ", postcode=" + postcode + "]";
    }

}