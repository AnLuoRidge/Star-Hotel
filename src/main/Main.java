package main;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import database.*;

public class Main extends Application {

    // TODO: relative path of jar
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/main/mainView.fxml"));
        Scene scene = new Scene(root, 930, 680);
        primaryStage.setTitle("xxx");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();


        CreateTable.createNewTable();
        CustomerDAO dao = new CustomerDAOImpl();
//        dao.insert(1710170001, "Cheng", "Zhu", true, "0450421907", "14/39 Cowper St", "Parramatta", "NSW", 2150, false, true);
//        testInsert.insert(1199665827, "Alex", "Zhu", true, "0450421907", "14/39 Cowper St", "Parramatta", "NSW", 2150, false, true);
//        testInsert.insert(1199993628, "Miyo", "Zhu", true, "0450421907", "14/39 Cowper St", "Parramatta", "NSW", 2150, false, true);
//        testInsert.insert(1195743622, "Hessler", "Button", true, "0450421907", "14/39 Cowper St", "Parramatta", "NSW", 2150, false, true);
//        testInsert.insert(1113621346, "Roge", "Zhu", true, "0450421907", "14/39 Cowper St", "Parramatta", "NSW", 2150, false, true);
//        testInsert.insert(1166773624, "Henry", "Zhu", true, "0450421907", "14/39 Cowper St", "Parramatta", "NSW", 2150, false, true);
//        testInsert.insert(1197669725, "Alice", "Zhu", true, "0450421907", "14/39 Cowper St", "Parramatta", "NSW", 2150, false, true);
//        testInsert.insert(1375787626, "Richard", "Zhu", true, "0450421907", "14/39 Cowper St", "Parramatta", "NSW", 2150, false, true);
        System.out.println("Show");
        SelectApp app = new SelectApp();
        app.selectAll();
//        app.select(1710170001);

//        System.out.println("Update");
//        UpdateApp Uapp = new UpdateApp();
//        Uapp.update(1710170001, "Angela", "Zhu", true, "0450421906", "14/40 Cowper St", "Parramatta", "NSW", 2150, false, true);
//
//        app.selectAll(1710170001);
//
//        System.out.println("Delete");
//        DeleteApp Dapp = new DeleteApp();
//        Dapp.delete(1710170001);
//
//        app.selectAll(1710170001);
    }

    public static void main(String[] args) {
        launch(args);
    }
}