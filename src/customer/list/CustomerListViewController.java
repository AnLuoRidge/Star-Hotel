package customer.list;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerListViewController implements Initializable {

    @FXML
    private Button addButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addButton.setOnAction(
                event -> {

                    ObservableList<Window> windows = Window.getWindows();
                    Stage stage = (Stage) windows.get(0);
                    System.out.println(stage);
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/customer/info/CustomerInfoView.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                    } catch (Exception nn) {

                        System.out.println(nn);
                    }


//                    System.out.println("Touch add"); // Lambda
                }
        );
    }
}
