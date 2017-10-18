package models;

import database.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class CustomerModel {
    private final SimpleIntegerProperty customerID = new SimpleIntegerProperty();
    private SimpleStringProperty firstName = new SimpleStringProperty();
    private SimpleStringProperty surname = new SimpleStringProperty();
    private SimpleStringProperty gender = new SimpleStringProperty();
    private String contactNum;
    private String address;
    private String suburb;
    private State state;
    private int postalCode;
    private boolean defaulter;
    private boolean frequenter;


    public int getCustomerID() {
        return customerID.get();
    }

    public void setCustomerID(int customerID) {
        this.customerID.set(customerID);
    }

    public SimpleIntegerProperty customerIDProperty() {
        return customerID;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(boolean gender) {
        if (gender == true) {
            this.gender.set("Male");
        } else {
            this.gender.set("Female");
        }
    }

    public SimpleStringProperty genderProperty() {
        return gender;
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

    public void setState(String state) {
        State input = State.valueOf(state);
        this.state = input;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
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


/**/