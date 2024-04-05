package edu.baylor.GroupFive.models;

public class Address {
    private int buildingNumber;
    private int zipCode;
    private String streetName;
    private int aptNumber;
    private String state;
    private String country;
    private Account account;
    private BillingInfo billingInfo;

    public Address(
            int buildingNumber_,
            int zipCode_,
            String streetName_,
            int aptNumber_,
            String state_,
            String country_,
            Account account_,
            BillingInfo billingInfo_
            ) {
        buildingNumber = buildingNumber_;
        zipCode = zipCode_;
        streetName = streetName_;
        aptNumber = aptNumber_;
        state = state_;
        country = country_;
        account = account_;
        billingInfo = billingInfo_;
    }

    public Account getAccount() { return account; }

    public void setAccount(Account account) { this.account = account; }

    public int getBuildingNumber() { return buildingNumber; }

    public void setBuildingNumber(int buildingNumber) { this.buildingNumber = buildingNumber; }

    public int getZipCode() { return zipCode; }

    public void setZipCode(int zipCode) { this.zipCode = zipCode; }

    public String getStreetName() { return streetName; }

    public void setStreetName(String streetName) { this.streetName = streetName; }

    public int getAptNumber() { return aptNumber; }

    public void setAptNumber(int aptNumber) { this.aptNumber = aptNumber; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public BillingInfo getBillingInfo() { return billingInfo; }

    public void setBillingInfo(BillingInfo billingInfo) { this.billingInfo = billingInfo; }
}