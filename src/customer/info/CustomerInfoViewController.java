package customer.info;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import customer.list.CustomerListViewController.OpenMode;
import dao.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.CustomerModel;

public class CustomerInfoViewController {

    @FXML
    private TextField addressTextField;

    @FXML
    private CheckBox defaulterCheckBox;

    @FXML
    private TextField contactNumTextField;

    @FXML
    private CheckBox frequenterCheckBox;

    @FXML
    private TextField postalCodeTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField suburbTextField;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ChoiceBox stateChoiceBox;


    public OpenMode om;

    private CustomerModel customerBuffer;

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
    final private ObservableList stateList = FXCollections.observableArrayList("NSW", "QLD", "SA", "TAS", "VIC", "WA", "ACT", "NT");

    @FXML
    public void initialize() {
        stateChoiceBox.setItems(stateList);


        confirmButton.setOnAction(



                // TODO: transfer them to model
                event -> {
                    // TODO: check all the fields are filled.
                    CustomerModel newCustomer = new CustomerModel();
//
                    newCustomer.setFirstName(firstNameTextField.getText());
                    newCustomer.setSurname(surnameTextField.getText());
                    newCustomer.setContactNum(contactNumTextField.getText());
                    newCustomer.setGender(maleRadioButton.isSelected());
                    newCustomer.setFrequenter(defaulterCheckBox.isSelected());
                    newCustomer.setDefaulter(frequenterCheckBox.isSelected());
                    newCustomer.setPostalCode(Integer.parseInt(postalCodeTextField.getText()));
                    newCustomer.setSuburb(suburbTextField.getText());
                    newCustomer.setAddress(addressTextField.getText());
                    if (stateChoiceBox.getValue() != null) {
                        newCustomer.setState(stateChoiceBox.getValue().toString());
                    }

                    CustomerDAO dao = new CustomerDAOImpl();

                    switch (om) {
                        case ADD:
                            dao.insert(newCustomer);

                        case EDIT:
                            newCustomer.setCustomerID(customerBuffer.getCustomerID());
                            dao.update(newCustomer);
                    }

                    closeStage();
                }

        );

        cancelButton.setOnAction(
                event -> closeStage()
        );

        ToggleGroup group = new ToggleGroup();
        maleRadioButton.setToggleGroup(group);
        femaleRadioButton.setToggleGroup(group);

    }

    private void closeStage() {
        ObservableList<Window> windows = Window.getWindows();
        Stage stage = (Stage) windows.get(1);
        stage.close();
        // TODO: get super controller, refresh
    }


    public void setCustomerBuffer(CustomerModel customerBuffer) {
        this.customerBuffer = customerBuffer;
    }

    public void fillData() {
        firstNameTextField.setText(customerBuffer.getFirstName());
        surnameTextField.setText(customerBuffer.getSurname());
        femaleRadioButton.setSelected(customerBuffer.getGender() == "Female");
        maleRadioButton.setSelected(customerBuffer.getGender() == "Male");
        contactNumTextField.setText(customerBuffer.getContactNum());
        addressTextField.setText(customerBuffer.getAddress());
        suburbTextField.setText(customerBuffer.getSuburb());
        stateChoiceBox.setValue(customerBuffer.getState());
        postalCodeTextField.setText(Integer.toString(customerBuffer.getPostalCode()));
        defaulterCheckBox.setSelected(customerBuffer.isDefaulter());
        frequenterCheckBox.setSelected(customerBuffer.isFrequenter());
        postalCodeTextField.setText(Integer.toString(customerBuffer.getPostalCode()));
    }
}
