package Airline;

import java.sql.*;

public class AccountData {
    private Connection connection;

    public AccountData(Connection connection) {
        this.connection = connection;
    }
}