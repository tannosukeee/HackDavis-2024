package Tickets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketDatabase {
    private Connection connection;

    public TicketDatabase(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
        createTicketTable();
    }

    private void createTicketTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS tickets (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "ticket_number INT NOT NULL," +
                "passenger_name VARCHAR(255) NOT NULL," +
                "price DOUBLE NOT NULL," +
                "ticket_level VARCHAR(20) NOT NULL" +
                ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
        }
    }

    public void addTicket(TicketData ticket) throws SQLException {
        String insertSQL = "INSERT INTO tickets (ticket_number, passenger_name, price, ticket_level) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setInt(1, ticket.getTicketNumber());
            preparedStatement.setString(2, ticket.getPassengerName());
            preparedStatement.setDouble(3, ticket.getPrice());
            preparedStatement.setString(4, ticket.getTicketLevel().getLevelName()); // Use getLevelName() method
            preparedStatement.executeUpdate();
        }
    }

    public List<TicketData> getAllTickets() throws SQLException {
        List<TicketData> tickets = new ArrayList<>();
        String selectSQL = "SELECT * FROM tickets";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                int ticketNumber = resultSet.getInt("ticket_number");
                String passengerName = resultSet.getString("passenger_name");
                double price = resultSet.getDouble("price");
                String ticketLevel = resultSet.getString("ticket_level");

                TicketLevel level = new TicketLevel(ticketLevel); // Use TicketLevel constructor
                TicketData ticket = new TicketData(ticketNumber, passengerName, price, level);
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    public TicketData getTicketByNumber(int ticketNumber) throws SQLException {
        String selectSQL = "SELECT * FROM tickets WHERE ticket_number = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, ticketNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String passengerName = resultSet.getString("passenger_name");
                    double price = resultSet.getDouble("price");
                    String ticketLevel = resultSet.getString("ticket_level");

                    TicketLevel level = new TicketLevel(ticketLevel); // Use TicketLevel constructor
                    return new TicketData(ticketNumber, passengerName, price, level);
                }
            }
        }
        return null;
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "username";
        String password = "password";

        try {
            TicketDatabase database = new TicketDatabase(url, user, password);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter ticket number: ");
            int ticketNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter passenger name: ");
            String passengerName = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter ticket level (ECONOMY, FIRST CLASS, BUSINESS CLASS): ");
            String ticketLevel = scanner.nextLine();

            TicketLevel level = new TicketLevel(ticketLevel);
            TicketData newTicket = new TicketData(ticketNumber, passengerName, price, level);
            database.addTicket(newTicket);

            System.out.println("Ticket added successfully.");

            scanner.close();
            database.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
