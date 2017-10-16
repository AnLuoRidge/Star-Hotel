package main;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class mainViewController implements Initializable {


    @FXML
    private Button customerButton;

    @FXML
    private Button reportButton;

    @FXML
    private Button roomManagementButton;


//    @FXML
//    private ImageView frontPicImageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roomManagementButton.setDisable(true);
        reportButton.setDisable(true);

        customerButton.setOnAction(
                event -> {

                    ObservableList<Window> windows = Window.getWindows();
                    Stage stage = (Stage) windows.get(0);
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/customer/list/CustomerListView.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                    } catch (Exception nn) {

                    }

                }


        );


    }

}

// Change Stage
/*
 * ObservableList<Stage> stage = FXRobotHelper.getStages();
 * Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FXML.fxml")));
 * stage.get(0).setScene(scene);
 */
/*
* 	public PrintController(String code, Stage primaryStage) {
		this.code = code;
		this.primaryStage = primaryStage;
		scene = new Scene(createContent3());
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		 scene.getStylesheets().add(getClass().getResource("application_print.css").toExternalForm());
		primaryStage.setTitle("提货宝");
		primaryStage.setFullScreen(true); // 全屏显示

		primaryStage.setScene(scene);
		primaryStage.show();
	}
*/