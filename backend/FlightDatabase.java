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
            String url = "jdbc:mysql://localhost:3306/flight";
            String username = "root";
            String password = "Tanblowsurmind@";
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
            statement.setDate(5, java.sql.Date.valueOf(flight.getDepartureDate().getYear() + "-" + flight.getDepartureDate().getMonth() + "-" + flight.getDepartureDate().getDay()));
            statement.setDate(6, java.sql.Date.valueOf(flight.getReturnDate().getYear() + "-" + flight.getReturnDate().getMonth() + "-" + flight.getReturnDate().getDay()));
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
                        new DepartureDate(resultSet.getDate("departure_date").toLocalDate().getDayOfMonth(), resultSet.getDate("departure_date").toLocalDate().getMonthValue(), resultSet.getDate("departure_date").toLocalDate().getYear()),
                        new ReturnDate(resultSet.getDate("return_date").toLocalDate().getDayOfMonth(), resultSet.getDate("return_date").toLocalDate().getMonthValue(), resultSet.getDate("return_date").toLocalDate().getYear())
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving flight from database: " + e.getMessage());
        }
        return flight;
    }
}
