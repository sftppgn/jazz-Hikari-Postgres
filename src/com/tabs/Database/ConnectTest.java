package com.tabs.Database;
import java.sql.*;

public class ConnectTest {
    public static java.sql.Connection connect(String url, String user, String password)
            throws ClassNotFoundException, java.sql.SQLException
    {
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

        int[] notes = {1,2,3} ;
        String songName = "songname1";
        final String songField = "name";
        final String id = "id";

        String insertStatement = "INSERT INTO song_names VALUES (1,2);";
        //System.out.println(insertStatement);
        st.executeUpdate(insertStatement);

        ResultSet rs = st.executeQuery("SELECT * FROM song_names");
        while (rs.next()) {
            System.out.print("Column 1 and 2 returned ");
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
        }
        rs.close();
        st.close();
        return dbConnection;

    }


}
