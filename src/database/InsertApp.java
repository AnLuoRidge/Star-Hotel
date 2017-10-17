package database;

import java.sql.*;


public class InsertApp {

    private Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:E:/StarHotel.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void insert(int customer_id, String first_name, String surname, boolean gender, String contact_num, String address, String suburb, String state, int postal_code, boolean defaulter, boolean frequenter){
        String insertRow = "INSERT INTO Customer(customer_id, first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter) \n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(insertRow)) {
            pstmt.setInt(1, customer_id);
            pstmt.setString(2, first_name);
            pstmt.setString(3, surname);
            pstmt.setBoolean(4,gender);
            pstmt.setString(5,contact_num);
            pstmt.setString(6,address);
            pstmt.setString(7,suburb);
            pstmt.setString(8,state);
            pstmt.setInt(9,postal_code);
            pstmt.setBoolean(10,defaulter);
            pstmt.setBoolean(11,frequenter);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        InsertApp Iapp = new InsertApp();
        Iapp.insert(1710170001, "Cheng","Zhu",true,"0450421907","14/39 Cowper St","Parramatta","NSW",2150, false,true);
    }
}
