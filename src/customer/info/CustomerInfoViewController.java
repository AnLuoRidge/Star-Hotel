package customer.info;

import customer.list.CustomerListViewController;
import customer.list.CustomerListViewController.OpenMode;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.CustomerModel;


public class CustomerInfoViewController {

    final private ObservableList<String> stateList = FXCollections.observableArrayList("NSW", "QLD", "SA", "TAS", "VIC", "WA", "ACT", "NT");
    public CustomerListViewController superViewController;
    public OpenMode om;
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
    private ChoiceBox<String> stateChoiceBox;

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
    private CustomerModel customerBuffer;

    @FXML
    public void initialize() {
        stateChoiceBox.setItems(stateList);
        stateChoiceBox.setValue("NSW");


        confirmButton.setOnAction(

                event -> {
                    // TODO: Validation
                    CustomerModel newCustomer = new CustomerModel();

                    newCustomer.setFirstName(firstNameTextField.getText());
                    newCustomer.setSurname(surnameTextField.getText());
                    newCustomer.setContactNum(contactNumTextField.getText());
                    newCustomer.setGender(maleRadioButton.isSelected());
                    newCustomer.setFrequenter(defaulterCheckBox.isSelected());
                    newCustomer.setDefaulter(frequenterCheckBox.isSelected());
                    if (!postalCodeTextField.getText().isEmpty()) {
                        newCustomer.setPostalCode(Integer.parseInt(postalCodeTextField.getText()));
                    }
                    newCustomer.setSuburb(suburbTextField.getText());
                    newCustomer.setAddress(addressTextField.getText());
                    if (stateChoiceBox.getValue() != null) {
                        newCustomer.setState(stateChoiceBox.getValue());
                    }

                    CustomerDAO dao = new CustomerDAOImpl();

                    if (om.equals(OpenMode.ADD)) {
                        dao.insert(newCustomer);
                    } else if (om.equals(OpenMode.EDIT)) {
                        newCustomer.setCustomerID(customerBuffer.getCustomerID());
                        dao.update(newCustomer);
                    }
                    superViewController.refresh();
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
        femaleRadioButton.setSelected(customerBuffer.getGender().equals("Female"));
        maleRadioButton.setSelected(customerBuffer.getGender().equals("Male"));
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
