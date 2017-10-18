package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.CustomerModel;
import database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String deleterow = "DELETE FROM Customer WHERE customer_id = ?";

        try (Connection conn = ConnectDB.connect();
             PreparedStatement Dpstmt = conn.prepareStatement(deleterow)) {
            // set the corresponding param
            Dpstmt.setInt(1, id);
            // execute the delete statement
            Dpstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public ObservableList<CustomerModel> search(String customerID) {
        Integer id = Integer.parseInt(customerID);
        String selectrow = "SELECT customer_id, first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter FROM Customer WHERE customer_id = ?";
        ObservableList<CustomerModel> resultList = FXCollections.observableArrayList();

        try (Connection conn = ConnectDB.connect();
             PreparedStatement Spstmt = conn.prepareStatement(selectrow)) {
            Spstmt.setInt(1, id);
            ResultSet rs = Spstmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                CustomerModel cus = new CustomerModel();
                cus.setCustomerID(rs.getInt("customer_id"));
                cus.setFirstName(rs.getString("first_name"));
                cus.setSurname(rs.getString("surname"));
                cus.setGender(rs.getBoolean("gender"));
                cus.setContactNum(rs.getString("contact_num"));
                cus.setAddress(rs.getString("address"));
                cus.setSuburb(rs.getString("suburb"));
                cus.setState(rs.getString("state"));
                cus.setPostalCode(rs.getInt("postal_code"));
                cus.setDefaulter(rs.getBoolean("defaulter"));
                cus.setFrequenter(rs.getBoolean("frequenter"));

                resultList.add(cus);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }
}
