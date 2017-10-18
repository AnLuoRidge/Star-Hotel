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
        String insertRow = "INSERT INTO Customer(first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter) \n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertRow)) {
//            pstmt.setNull(1, 0);
            pstmt.setString(1, cm.getFirstName());
            pstmt.setString(2, cm.getSurname());
            pstmt.setBoolean(3, cm.getGender() == "Male");
            pstmt.setString(4, cm.getContactNum());
            pstmt.setString(5, cm.getAddress());
            pstmt.setString(6, cm.getSuburb());
            pstmt.setString(7, cm.getState());
            pstmt.setInt(8, cm.getPostalCode());
            pstmt.setBoolean(9, cm.isDefaulter());
            pstmt.setBoolean(10, cm.isFrequenter());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(CustomerModel cm) {
        String updateRow = "UPDATE Customer SET first_name = ?, surname = ?, gender = ?, contact_num = ?, address = ?, suburb = ?, state = ?, postal_code = ?, defaulter = ?, frequenter = ? WHERE customer_id = ?";
        try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(updateRow)) {
            pstmt.setString(1, cm.getFirstName());
            pstmt.setString(2, cm.getSurname());
            pstmt.setBoolean(3, cm.getGender() == "Male");
            pstmt.setString(4, cm.getContactNum());
            pstmt.setString(5, cm.getAddress());
            pstmt.setString(6, cm.getSuburb());
            pstmt.setString(7, cm.getState());
            pstmt.setInt(8, cm.getPostalCode());
            pstmt.setBoolean(9, cm.isDefaulter());
            pstmt.setBoolean(10, cm.isFrequenter());
            pstmt.setInt(11, cm.getCustomerID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String deleterow = "DELETE FROM Customer WHERE customer_id = ?";

        try (Connection conn = ConnectDB.connect();
             PreparedStatement ps = conn.prepareStatement(deleterow)) {
            // set the corresponding param
            ps.setInt(1, id);
            // execute the delete statement
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public ObservableList<CustomerModel> search(String keyword) {
        String selectrow = "SELECT customer_id, first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter FROM Customer WHERE customer_id LIKE ? OR first_name LIKE ? OR surname LIKE ?";
        ObservableList<CustomerModel> resultList = FXCollections.observableArrayList();

        try (Connection conn = ConnectDB.connect();

             PreparedStatement Spstmt = conn.prepareStatement(selectrow)) {
            Spstmt.setString(1, "%" + keyword + "%");
            Spstmt.setString(2, "%" + keyword + "%");
            Spstmt.setString(3, "%" + keyword + "%");

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
