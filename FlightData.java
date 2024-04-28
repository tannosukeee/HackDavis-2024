package Flight;

public class FlightData {
    private FlightDatabase database;

    public FlightData() {
        this.database = new FlightDatabase();
        initializeFlights();
    }

    private void initializeFlights() {
        DepartureDate departureDate1 = new DepartureDate(1, 5, 2024);
        ReturnDate returnDate1 = new ReturnDate(15, 5, 2024);
        FlightDetails flight1 = new FlightDetails("ABC123", "Airline 1", "JFK", "LAX", departureDate1, returnDate1);

        DepartureDate departureDate2 = new DepartureDate(5, 5, 2024);
        ReturnDate returnDate2 = new ReturnDate(20, 5, 2024);
        FlightDetails flight2 = new FlightDetails("XYZ456", "Airline 2", "LHR", "CDG", departureDate2, returnDate2);
        
        DepartureDate departureDate3 = new DepartureDate(9, 5, 2024);
        ReturnDate returnDate3 = new ReturnDate(25, 5, 2024);
        FlightDetails flight3 = new FlightDetails("ABC456", "Airline 3", "SFO", "LAS", departureDate3, returnDate3);

        DepartureDate departureDate4 = new DepartureDate(13, 5, 2024);
        ReturnDate returnDate4 = new ReturnDate(30, 5, 2024);
        FlightDetails flight4 = new FlightDetails("XYZ789", "Airline 4", "ANC", "DEN", departureDate4, returnDate4);

        database.saveFlight(flight1);
        database.saveFlight(flight2);
        database.saveFlight(flight3);
        database.saveFlight(flight4);
    }

    public void addFlight(FlightDetails flight) {
        database.saveFlight(flight);
    }

    public FlightDetails getFlight(String flightCode) {
        return database.getFlight(flightCode);
    }

    public void getFlightsByDate() {
    }

    public static void main(String[] args) {
        FlightData flightData = new FlightData();
        flightData.getFlightsByDate();
    }
}
