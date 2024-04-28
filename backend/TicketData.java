package Tickets;

public class TicketData {
    private int ticketNumber;
    private String passengerName;
    private double price;
    private TicketLevel ticketLevel;

    public TicketData(int ticketNumber, String passengerName, double price, TicketLevel ticketLevel) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.price = price;
        this.ticketLevel = ticketLevel;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TicketLevel getTicketLevel() {
        return ticketLevel;
    
}
}