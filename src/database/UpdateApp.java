package database;
import java.sql.*;

public class UpdateApp {
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
    public void update(int customer_id, String first_name, String surname, boolean gender, String contact_num, String address, String suburb, String state, int postal_code, boolean defaulter, boolean frequenter){
        String updateRow = "UPDATE Customer SET first_name = ?, surname = ?, gender = ?, contact_num = ?, address = ?, suburb = ?, state = ?, postal_code = ?, defaulter = ?, frequenter = ? WHERE customer_id = ?";
        try (Connection conn = this.connect();
        PreparedStatement Upstmt = conn.prepareStatement(updateRow)) {
            Upstmt.setInt(11, customer_id);
            Upstmt.setString(1, first_name);
            Upstmt.setString(2, surname);
            Upstmt.setBoolean(3,gender);
            Upstmt.setString(4,contact_num);
            Upstmt.setString(5,address);
            Upstmt.setString(6,suburb);
            Upstmt.setString(7,state);
            Upstmt.setInt(8,postal_code);
            Upstmt.setBoolean(9,defaulter);
            Upstmt.setBoolean(10,frequenter);
            Upstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {

        UpdateApp Uapp = new UpdateApp();
        Uapp.update(1710170001, "Cheng","Zhu",true,"0450421906","14/40 Cowper St","Parramatta","NSW",2150, false,true);
    }
}
