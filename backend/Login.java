package Airline;

import java.sql.*;
import java.util.Scanner;

public class Login {
    private Connection connection;

    public Login(Connection connection) {
        this.connection = connection;
    }

    public boolean authenticateUser(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                try (ResultSet rs = pstmt.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            System.err.println("Error authenticating user: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        Conn databaseConnection = new Conn();
        Connection conn = databaseConnection.getConnection();

        Login login = new Login(conn);

        System.out.println("Username: ");
        String username = sc.nextLine();
        
        System.out.println("Password: ");
        String password = sc.nextLine();

        boolean isAuthenticated = login.authenticateUser(username, password);

        if (isAuthenticated) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }

        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
}
