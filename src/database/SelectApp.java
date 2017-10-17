package database;
import java.sql.*;

public class SelectApp {

    public void selectAll(int customer_id){
        String selectrow = "SELECT customer_id, first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter FROM Customer WHERE customer_id = ?";

        try (Connection conn = ConnectDB.connect();
             PreparedStatement Spstmt = conn.prepareStatement(selectrow)){
                Spstmt.setInt(1, customer_id);
                ResultSet rs = Spstmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getInt("customer_id") +  "\t" +
                        rs.getString("first_name") + "\t" +
                        rs.getString("surname") + "\t" +
                        rs.getBoolean("gender") + "\t" +
                        rs.getString("contact_num") + "\t" +
                        rs.getString("address") + "\t" +
                        rs.getString("suburb") + "\t" +
                        rs.getString("state") + "\t" +
                        rs.getInt("postal_code") + "\t" +
                        rs.getBoolean("defaulter") + "\t" +
                        rs.getBoolean("frequenter") + "\t"
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectPart(){
        String selectpartrow = "SELECT customer_id, first_name, surname, gender, contact_num FROM Customer";

        try (Connection conn = ConnectDB.connect();
             Statement Sstmt = conn.createStatement();
             ResultSet rs = Sstmt.executeQuery(selectpartrow)){
            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getInt("customer_id") +  "\t" +
                                rs.getString("first_name") + "\t" +
                                rs.getString("surname") + "\t" +
                                rs.getBoolean("gender") + "\t" +
                                rs.getString("contact_num") + "\t"
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


//    public static void main(String[] args) {
//        SelectApp app = new SelectApp();
//        app.selectAll(1710170001);
//        System.out.println("Part table");
//        app.selectPart();
//    }

}
