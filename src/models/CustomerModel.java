package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CustomerModel {

    private final SimpleIntegerProperty customerID = new SimpleIntegerProperty();
    private SimpleStringProperty firstName = new SimpleStringProperty();
    private SimpleStringProperty surname = new SimpleStringProperty();
    private SimpleStringProperty gender = new SimpleStringProperty();
    private SimpleStringProperty contactNum = new SimpleStringProperty();
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
        if (gender) {
            this.gender.set("Male");
        } else {
            this.gender.set("Female");
        }
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public String getContactNum() {
        return contactNum.get();
    }

    public void setContactNum(String contactNum) {
        this.contactNum.set(contactNum);
    }

    public SimpleStringProperty contactNumProperty() {
        return contactNum;
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

    public String getState() {
        return state.toString();
    }

    public void setState(String state) {
        this.state = State.valueOf(state);
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

    public enum State {
        NSW, QLD, SA, TAS, VIC, WA, ACT, NT
    }
}