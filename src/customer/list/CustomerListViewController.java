package customer.list;

import customer.info.CustomerInfoViewController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    Button deleteButton;
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
    @FXML
    private TextField searchTextField;

    private ObservableList<CustomerModel> dataSource;

    public void refresh() {
        CustomerDAO dao = new CustomerDAOImpl();
        dataSource = dao.showAll();
        customerTableView.setItems(dataSource);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        refresh();
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        searchButton.setOnAction(
                event -> {
                    CustomerDAO dao = new CustomerDAOImpl();
                    if (!searchTextField.getText().isEmpty()) {
                        ObservableList<CustomerModel> results = dao.search(searchTextField.getText().toString());
                        customerTableView.setItems(results);
                    } else {
                        refresh();
                    }
                    customerTableView.refresh();
                }
        );

        addButton.setOnAction(
                event -> openInfoViewAs(OpenMode.ADD)
        );

        editButton.setOnAction(
                event -> openInfoViewAs(OpenMode.EDIT)
        );

        deleteButton.setOnAction(
                event -> {
                    int selectedIndex = customerTableView.getSelectionModel().getSelectedIndex();
                    CustomerDAO dao = new CustomerDAOImpl();
                    dao.delete(dataSource.get(selectedIndex).getCustomerID());
                    customerTableView.getItems().remove(selectedIndex);
                }
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
            CustomerInfoViewController controller = loader.getController();
            if (om.equals(OpenMode.EDIT)) {
                dialogStage.setTitle("Edit");
                int selectedIndex = customerTableView.getSelectionModel().getSelectedIndex();
                controller.setCustomerBuffer(dataSource.get(selectedIndex));
                controller.fillData();
            }
            controller.om = om;

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();


        } catch (Exception nn) {


        }
    }

    public enum OpenMode {
        ADD, EDIT
    }
}

