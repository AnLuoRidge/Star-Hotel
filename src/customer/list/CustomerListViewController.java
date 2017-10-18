package customer.list;

import customer.info.CustomerInfoViewController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

import dao.*;
import models.CustomerModel;

public class CustomerListViewController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button backButton;

    @FXML
    private Button searchButton;
    @FXML
    private TableView customerTableView;
    @FXML
    private TableColumn<CustomerModel, Integer> customerIdColumn;
    @FXML
    private TableColumn<CustomerModel, String> firstNameColumn;

    @FXML
    private TableColumn<CustomerModel, String> surnameColumn;

    @FXML
    private TableColumn<CustomerModel, String> genderColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        CustomerDAO dao = new CustomerDAOImpl();
        customerTableView.setItems(dao.showAll());
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

//        customerIdColumn.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty());


        addButton.setOnAction(
                event -> openInfoViewAs(OpenMode.ADD)
        );

        editButton.setOnAction(
                event -> openInfoViewAs(OpenMode.EDIT)
        );

        backButton.setOnAction(
                event -> {

                    ObservableList<Window> windows = Window.getWindows();
                    Stage stage = (Stage) windows.get(0);
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/main/mainView.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                    } catch (Exception nn) {


                    }
                }
        );

    }

    private void openInfoViewAs(OpenMode om) {

        ObservableList<Window> windows = Window.getWindows();
        Stage stage = (Stage) windows.get(0);
//                      FXMLLoader loader;
        try {
// Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/customer/info/CustomerInfoView.fxml"));
            Pane page = (Pane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add");
            dialogStage.initModality(Modality.WINDOW_MODAL);
//                          dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
//
            CustomerInfoViewController controller = loader.getController();
            controller.om = om;
//                controller.isAdd = (om == OpenMode.ADD) ? true : false;
//                          controller.setDialogStage(dialogStage);
//                          controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();


//                          loader = FXMLLoader.load(getClass().getResource("/customer/info/CustomerInfoView.fxml"));
//                          Pane page = (Pane) loader;
//                          Scene scene = new Scene(page);
//                          stage.setScene(scene);
//
//                          CustomerInfoViewController controller = loader.getController();
//                          controller.isAdd = true;

//                                stage.showAndWait();
        } catch (Exception nn) {


        }
    }

    public enum OpenMode {
        ADD, EDIT
    }
}

