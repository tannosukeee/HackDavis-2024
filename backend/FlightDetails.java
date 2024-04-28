package Flight;

public class FlightDetails {
    private String flightCode;
    private String airline;
    private String departureCity;
    private String arrivalCity;
    private DepartureDate departureDate;
    private ReturnDate returnDate;

    public FlightDetails(String flightCode, String airline, String departureCity, String arrivalCity, DepartureDate departureDate, ReturnDate returnDate) {
        this.flightCode = flightCode;
        this.airline = airline;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public DepartureDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(DepartureDate departureDate) {
        this.departureDate = departureDate;
    }

    public ReturnDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(ReturnDate returnDate) {
        this.returnDate = returnDate;
    }
}
