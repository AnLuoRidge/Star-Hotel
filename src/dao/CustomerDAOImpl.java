package dao;

import database.ConnectDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.CustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ObservableList<CustomerModel> showAll() {
        String selectrow = "SELECT customer_id, first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter FROM Customer";

        ObservableList<CustomerModel> resultList = FXCollections.observableArrayList();
        try (Connection conn = ConnectDB.connect();
             PreparedStatement ps = conn.prepareStatement(selectrow)) {
            ResultSet rs = ps.executeQuery();
            // loop through the result set
            while (rs.next()) {
                CustomerModel ctm = new CustomerModel();
                ctm.setCustomerID(rs.getInt("customer_id"));
                ctm.setFirstName(rs.getString("first_name"));
                ctm.setSurname(rs.getString("surname"));
                ctm.setGender(rs.getBoolean("gender"));
                ctm.setContactNum(rs.getString("contact_num"));
                ctm.setAddress(rs.getString("address"));
                ctm.setSuburb(rs.getString("suburb"));
                ctm.setState(rs.getString("state"));
                ctm.setPostalCode(rs.getInt("postal_code"));
                ctm.setDefaulter(rs.getBoolean("defaulter"));
                ctm.setFrequenter(rs.getBoolean("frequenter"));

                resultList.add(ctm);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }

    @Override
    public void insert(CustomerModel ctm) {
        String insertRow = "INSERT INTO Customer(first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter) \n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertRow)) {
            pstmt.setString(1, ctm.getFirstName());
            pstmt.setString(2, ctm.getSurname());
            pstmt.setBoolean(3, ctm.getGender().equals("Male"));
            pstmt.setString(4, ctm.getContactNum());
            pstmt.setString(5, ctm.getAddress());
            pstmt.setString(6, ctm.getSuburb());
            pstmt.setString(7, ctm.getState());
            pstmt.setInt(8, ctm.getPostalCode());
            pstmt.setBoolean(9, ctm.isDefaulter());
            pstmt.setBoolean(10, ctm.isFrequenter());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(CustomerModel ctm) {
        String updateRow = "UPDATE Customer SET first_name = ?, surname = ?, gender = ?, contact_num = ?, address = ?, suburb = ?, state = ?, postal_code = ?, defaulter = ?, frequenter = ? WHERE customer_id = ?";
        try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(updateRow)) {
            pstmt.setString(1, ctm.getFirstName());
            pstmt.setString(2, ctm.getSurname());
            pstmt.setBoolean(3, ctm.getGender().equals("Male"));
            pstmt.setString(4, ctm.getContactNum());
            pstmt.setString(5, ctm.getAddress());
            pstmt.setString(6, ctm.getSuburb());
            pstmt.setString(7, ctm.getState());
            pstmt.setInt(8, ctm.getPostalCode());
            pstmt.setBoolean(9, ctm.isDefaulter());
            pstmt.setBoolean(10, ctm.isFrequenter());
            pstmt.setInt(11, ctm.getCustomerID());
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
                CustomerModel ctm = new CustomerModel();
                ctm.setCustomerID(rs.getInt("customer_id"));
                ctm.setFirstName(rs.getString("first_name"));
                ctm.setSurname(rs.getString("surname"));
                ctm.setGender(rs.getBoolean("gender"));
                ctm.setContactNum(rs.getString("contact_num"));
                ctm.setAddress(rs.getString("address"));
                ctm.setSuburb(rs.getString("suburb"));
                ctm.setState(rs.getString("state"));
                ctm.setPostalCode(rs.getInt("postal_code"));
                ctm.setDefaulter(rs.getBoolean("defaulter"));
                ctm.setFrequenter(rs.getBoolean("frequenter"));

                resultList.add(ctm);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }
}
