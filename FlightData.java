package Flight;

import java.time.LocalDate;

public class FlightData {
	
	

	public static void main(String[] args) {
        // Create DepartureDate instance
        DepartureDate departureDate1 = new DepartureDate(01, 05, 2024);
        DepartureDate departureDate2 = new DepartureDate(05, 05, 2024);

        // Create ReturnDate instance (if applicable)
        ReturnDate returnDate1 = new ReturnDate(15, 05, 2024);
        ReturnDate returnDate2 = new ReturnDate(20, 05, 2024);

        // Create Flight instances
        Flight flight1 = new Flight("ABC123", "JFK", "LAX");
        Flight flight2 = new Flight("XYZ456", "LHR", "CDG");

        // Create FlightData instances
        FlightData flightData1 = new FlightData(departureDate1, returnDate1, flight1);
        FlightData flightData2 = new FlightData(departureDate2, returnDate2, flight2);

        // Display flight data
        System.out.println("Flight Data 1:");
        System.out.println("Departure Date: " + flightData1.getDepartureDate().getDate());
        if (flightData1.getReturnDate() != null) {
            System.out.println("Return Date: " + flightData1.getReturnDate().getDate());
        }
        System.out.println("Flight Number: " + flightData1.getFlight().getFlightNumber());
        System.out.println("Departure Airport: " + flightData1.getFlight().getDepartureAirport());
        System.out.println("Arrival Airport: " + flightData1.getFlight().getArrivalAirport());

        System.out.println("\nFlight Data 2:");
        System.out.println("Departure Date: " + flightData2.getDepartureDate().getDate());
        if (flightData2.getReturnDate() != null) {
            System.out.println("Return Date: " + flightData2.getReturnDate().getDate());
        }
        System.out.println("Flight Number: " + flightData2.getFlight().getFlightNumber());
        System.out.println("Departure Airport: " + flightData2.getFlight().getDepartureAirport());
        System.out.println("Arrival Airport: " + flightData2.getFlight().getArrivalAirport());
    }
}