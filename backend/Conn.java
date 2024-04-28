package Airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/airline";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Tanblowsurmind@";

    private Connection connection;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Conn databaseConnection = new Conn();
        Connection conn = databaseConnection.getConnection();
        
        databaseConnection.closeConnection();
    }
}
