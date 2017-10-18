package dao;

import javafx.collections.ObservableList;
import models.CustomerModel;
import database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ObservableList<CustomerModel> showAll() {
        return SelectApp.selectAll();
    }

    @Override
    public void insert(CustomerModel cm) {
        // TODO: check before insert...increment
        String insertRow = "INSERT INTO Customer(customer_id, first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter) \n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertRow)) {
            pstmt.setNull(1, 0);
            pstmt.setString(2, cm.getFirstName());
            pstmt.setString(3, cm.getSurname());
            pstmt.setBoolean(4, cm.getGender() == "Male");
            pstmt.setString(5, cm.getContactNum());
            pstmt.setString(6, cm.getAddress());
            pstmt.setString(7, cm.getSuburb());
            pstmt.setString(8, cm.getState());
            pstmt.setInt(9, cm.getPostalCode());
            pstmt.setBoolean(10, cm.isDefaulter());
            pstmt.setBoolean(11, cm.isFrequenter());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(CustomerModel cm) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public CustomerModel search(int customerID) {
        return null;
    }
}
