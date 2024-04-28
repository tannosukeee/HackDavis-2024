package Flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightDatabase {
    private Connection connection;

    public FlightDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/your_database";
            String username = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }

    public void saveFlight(FlightDetails flight) {
        try {
            String query = "INSERT INTO flights (flight_code, airline, departure_city, arrival_city, departure_date, return_date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, flight.getFlightCode());
            statement.setString(2, flight.getAirline());
            statement.setString(3, flight.getDepartureCity());
            statement.setString(4, flight.getArrivalCity());
            statement.setDate(5, java.sql.Date.valueOf(flight.getDepartureDate()));
            statement.setDate(6, java.sql.Date.valueOf(flight.getReturnDate()));
            statement.executeUpdate();
            System.out.println("Flight saved to database: " + flight.getFlightCode());
        } catch (SQLException e) {
            System.err.println("Error saving flight to database: " + e.getMessage());
        }
    }

    public FlightDetails getFlight(String flightCode) {
        FlightDetails flight = null;
        try {
            String query = "SELECT * FROM flights WHERE flight_code = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, flightCode);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                flight = new FlightDetails(
                        resultSet.getString("flight_code"),
                        resultSet.getString("airline"),
                        resultSet.getString("departure_city"),
                        resultSet.getString("arrival_city"),
                        resultSet.getDate("departure_date").toLocalDate(),
                        resultSet.getDate("return_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving flight from database: " + e.getMessage());
        }
        return flight;
    }
}
