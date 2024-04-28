package Flight;

import java.time.LocalDate;
import java.util.Scanner;

public class FlightData {
    private FlightDatabase database;
    private Scanner scanner;

    public FlightData() {
        this.database = new FlightDatabase();
        this.scanner = new Scanner(System.in);
        initializeFlights(); // Initialize flights in the database
    }

    private void initializeFlights() {
        FlightDetails flight1 = new FlightDetails("ABC123", "Airline 1", "JFK", "LAX",
                LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 15));
        FlightDetails flight2 = new FlightDetails("XYZ456", "Airline 2", "LHR", "CDG",
                LocalDate.of(2024, 5, 5), LocalDate.of(2024, 5, 20));

        database.saveFlight(flight1);
        database.saveFlight(flight2);
    }

    public void addFlight(FlightDetails flight) {
        database.saveFlight(flight);
    }

    public FlightDetails getFlight(String flightCode) {
        return database.getFlight(flightCode);
    }

    public void getFlightsByDate() {
        System.out.println("Enter the date of departure (YYYY-MM-DD): ");
        String inputDateStr = scanner.nextLine();
        LocalDate inputDate = LocalDate.parse(inputDateStr);

        // Example query to get flights on a specific date
        // You would typically replace this with a database query
        FlightDetails flight1 = new FlightDetails("ABC123", "Airline 1", "JFK", "LAX",
                LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 15));
        FlightDetails flight2 = new FlightDetails("XYZ456", "Airline 2", "LHR", "CDG",
                LocalDate.of(2024, 5, 5), LocalDate.of(2024, 5, 20));

        if (inputDate.isEqual(flight1.getDepartureDate()) || inputDate.isEqual(flight2.getDepartureDate())) {
            System.out.println("Available flights on " + inputDate + ":");
            System.out.println("1. " + flight1.getFlightCode() + " - " + flight1.getAirline() +
                    " - " + flight1.getDepartureCity() + " to " + flight1.getArrivalCity());
            System.out.println("2. " + flight2.getFlightCode() + " - " + flight2.getAirline() +
                    " - " + flight2.getDepartureCity() + " to " + flight2.getArrivalCity());
        } else {
            System.out.println("No flights available on " + inputDate);
        }
    }

    public static void main(String[] args) {
        FlightData flightData = new FlightData();
        flightData.getFlightsByDate();
    }
}
