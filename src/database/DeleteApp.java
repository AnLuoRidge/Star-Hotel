package database;
import java.sql.*;

public class DeleteApp {
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
    public void delete(int customer_id) {
        String deleterow = "DELETE FROM Customer WHERE customer_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement Dpstmt = conn.prepareStatement(deleterow)) {
            // set the corresponding param
            Dpstmt.setInt(1, customer_id);
            // execute the delete statement
            Dpstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        DeleteApp Dapp = new DeleteApp();
        Dapp.delete(1710170001);
    }

}
