package Airline;

import java.util.Scanner;
import java.sql.*;

public class CreateAccount {
	private Connection connection;

	public CreateAccount(Connection connection) {
		this.connection = connection;
	}

	public void registerUser(String username, String email, String password) {
		try {
			String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
			try (PreparedStatement pstmt = connection.prepareStatement(query)) {
				pstmt.setString(1, username);
				pstmt.setString(2, email);
				pstmt.setString(3, password);
				pstmt.executeUpdate();
				System.out.println("Account created successfully!");
			}
		} catch (SQLException e) {
			System.err.println("Error registering user: " + e.getMessage());
		}
	}

	public void createAccountWithConfirmation() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your username:");
		String username = scanner.nextLine();

		System.out.println("Enter your email:");
		String email = scanner.nextLine();

		String password;
		String confirmPassword;

		do {
			System.out.println("Enter your password:");
			password = scanner.nextLine();

			System.out.println("Confirm your password:");
			confirmPassword = scanner.nextLine();

			if (!password.equals(confirmPassword)) {
				System.out.println("Password and confirm password do not match. Please try again.");
			}
		} while (!password.equals(confirmPassword));

		registerUser(username, email, password);
	}

	public static void main(String[] args) {
		Conn databaseConnection = new Conn();
		Connection conn = databaseConnection.getConnection();

		CreateAccount accountCreator = new CreateAccount(conn);
		accountCreator.createAccountWithConfirmation();

		databaseConnection.closeConnection();
	}
}
