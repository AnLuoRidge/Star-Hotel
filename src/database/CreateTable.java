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
        String url = "jdbc:sqlite:memory";

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
    }

//   public static void main(String[] args) {
//        createNewTable();
//    }
}
