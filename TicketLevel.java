package Tickets;

public class TicketLevel {
    private String levelName;

    public TicketLevel(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public String toString() {
        return levelName;
    }
}
