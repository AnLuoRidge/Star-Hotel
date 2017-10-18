package models;

import database.*;

public class CustomerModel {
    private int customerID;
    private String firstName;
    private String surname;
    private boolean gender;
    private String contactNum;
    private String address;
    private String suburb;
    private State state;
    private String postalCode;
    private boolean defaulter;
    private boolean frequenter;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isDefaulter() {
        return defaulter;
    }

    public void setDefaulter(boolean defaulter) {
        this.defaulter = defaulter;
    }

    public boolean isFrequenter() {
        return frequenter;
    }

    public void setFrequenter(boolean frequenter) {
        this.frequenter = frequenter;
    }


    /*
* NSW|New South Wales
* QLD|Queensland
* SA|South Australia
* TAS|Tasmania
* VIC|Victoria
* WA|Western Australia
* ACT|Australian Capital Territory
* NT|Northern Territory
* */

    enum State {
        NSW, QLD, SA, TAS, VIC, WA, ACT, NT
    }


//    public Exception save () {
//
//    }



}
