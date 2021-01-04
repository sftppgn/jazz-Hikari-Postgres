package com.tabs.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseSelect {

    public static java.sql.Connection connect(String url, String user, String password)
            throws ClassNotFoundException, java.sql.SQLException {
        /*
         * Register the PostgreSQL JDBC driver.
         * This may throw a ClassNotFoundException.
         */
        Class.forName("org.postgresql.Driver");
        /*
         * Tell the driver manager to connect to the database specified with the URL.
         * This may throw an SQLException.
         */
        Connection dbConnection = DriverManager.getConnection(url, user, password);

        Statement st = dbConnection.createStatement();

        return dbConnection;
    }
}
