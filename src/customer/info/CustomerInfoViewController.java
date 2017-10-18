package customer.info;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import dao.*;

public class CustomerInfoViewController {

    @FXML
    private TextField addressTextField;

    @FXML
    private RadioButton defaulterButton;

    @FXML
    private TextField contactNumTextField;

    @FXML
    private RadioButton frequenterButton;

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

    public boolean isAdd;

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
                    ArrayList inputs = new ArrayList();

                    firstNameTextField.getText();
                    surnameTextField.getText();
                    femaleRadioButton.isSelected();
                    maleRadioButton.isSelected();
                    postalCodeTextField.getText();
                    contactNumTextField.getText();
                    stateChoiceBox.getValue();
                    suburbTextField.getText();
                    addressTextField.getText();
                    defaulterButton.isSelected();
                    frequenterButton.isSelected();
                    System.out.println(stateChoiceBox.getValue());
                    System.out.println(postalCodeTextField.getText());
                    System.out.println("Touch confirm");

                    CustomerDAO dao = new CustomerDAOImpl();
                    // dao.insert();
                }

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

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//
//    }

}
