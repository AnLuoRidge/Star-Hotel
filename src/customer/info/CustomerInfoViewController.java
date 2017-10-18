package customer.info;

import customer.list.CustomerListViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

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
    private ChoiceBox stateChoiceBox; // no <?> !!!!


    public OpenMode om;

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

//    final private String[] states = {"NSW", "QLD", "SA", "TAS", "VIC", "WA", "ACT", "NT"};
//    final private ObservableList statesList = FXCollections.observableArrayList(Arrays.asList(states));

    @FXML
    public void initialize() {
        stateChoiceBox.setItems(stateList);
//        stateChoiceBox.getItems().addAll(FXCollections.observableArrayList(Arrays.asList(states))); // same
//        stateChoiceBox.getItems().addAll("dd", "dc");


        this.confirmButton.setOnAction(

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
                    dao.insert(newCustomer);
//                    CustomerListViewController.
                    closeStage();
                }

        );

        cancelButton.setOnAction(
                event -> closeStage()
        );

        ToggleGroup group = new ToggleGroup();
//        RadioButton button1 = new RadioButton("select first");
        maleRadioButton.setToggleGroup(group);
        femaleRadioButton.setToggleGroup(group);
//        maleRadioButton.setSelected(true);

        postalCodeTextField.setText("2007");
        // postalCodeTextField.getText()
        //stateChoiceBox = new ChoiceBox(FXCollections.observableArrayList("A", "B", "C"));
//        stateChoiceBox.setItems(FXCollections.observableArrayList(
//                "A", "B", new Separator(), "C", "D");
        //)
    }

    private void closeStage() {
        ObservableList<Window> windows = Window.getWindows();
        Stage stage = (Stage) windows.get(1);
        stage.close();
    }


//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//
//    }

}
