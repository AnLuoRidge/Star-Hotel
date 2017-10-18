package database;

import java.sql.*;


public class CreateTable {

    public static void createNewTable() {
        // SQLite connection string
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:StarHotel.db";

        // SQL statement for creating a new table
        String createTable = "CREATE TABLE IF NOT EXISTS Customer (\n"
                + "	customer_id integer PRIMARY KEY,\n"
                + "	first_name text NOT NULL,\n"
                + "	surname text NOT NULL,\n"
                + "	gender bool NOT NULL,\n"
                + "	contact_num text NOT NULL,\n"
                + "	address text,\n"
                + "	suburb text,\n"
                + "	state text,\n"
                + "	postal_code INTEGER ,\n"
                + "	defaulter bool NOT NULL,\n"
                + "	frequenter bool NOT NULL\n"
                + ");";


        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        insert(171017001, "Cheng", "Zhu", true, "0450421907", "14/39 Cowper St", "Parramatta", "NSW", 2150, false, true);

    }

    public static void insert(int customer_id, String first_name, String surname, boolean gender, String contact_num, String address, String suburb, String state, int postal_code, boolean defaulter, boolean frequenter) {
        // TODO: check before insert...increment
        String insertRow = "INSERT INTO Customer(customer_id, first_name, surname, gender, contact_num, address, suburb, state, postal_code, defaulter, frequenter) \n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertRow)) {
            pstmt.setInt(1, customer_id);
            pstmt.setString(2, first_name);
            pstmt.setString(3, surname);
            pstmt.setBoolean(4, gender);
            pstmt.setString(5, contact_num);
            pstmt.setString(6, address);
            pstmt.setString(7, suburb);
            pstmt.setString(8, state);
            pstmt.setInt(9, postal_code);
            pstmt.setBoolean(10, defaulter);
            pstmt.setBoolean(11, frequenter);
            pstmt.executeUpdate();
        } catch (SQLException e) {
//            System.out.println(e.getMessage());
        }
    }

}
