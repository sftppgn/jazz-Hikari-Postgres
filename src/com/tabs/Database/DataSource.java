package com.tabs.Database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Arrays;
import java.util.Base64;

public class DataSource {

    private static HikariConfig config = new HikariConfig();
    //HikariConfig config = new HikariConfig(
    //        "datasource.properties" );
    public static HikariDataSource ds;
//    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/jazz");
        config.setUsername("jazz");
        config.setPassword("allwedoisjazz");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public DataSource() {
    }

    public static Connection getConnection() throws SQLException, SQLException {
        return ds.getConnection();
    }

    public static void fetchData(String columnName) throws SQLException {
        //String SQL_QUERY = "select "+columnName+" from song_names";
        String SQL_QUERY = "select * from song_names";
        //String SQL_QUERY = "INSERT INTO song_names VALUES (7,8)";
        int result = 0;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery();) {
            while (rs.next()) {

                //InputStream in;
                //BufferedReader br = new BufferedReader(new InputStreamReader(in));

                System.out.println(rs.getString(1));
                String songNameWrite = new String(rs.getBytes(2), StandardCharsets.UTF_8);
                System.out.println("songNameWrite "+songNameWrite);

            }
        }
    }

    public void writeSong(Integer songId, byte[] songName) throws SQLException {
        String SQL_QUERY = "INSERT INTO song_names (id,name) VALUES (?,?)";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jazz", "jazz", "allwedoisjazz");
             PreparedStatement pst = conn.prepareStatement(SQL_QUERY)) {
            //String songNameWrite = new String(songName, StandardCharsets.UTF_8);
            //System.out.println("songNameWrite "+songNameWrite);
            pst.setInt(1, songId);
            pst.setBytes(2, songName);
            //pst.setObject(2,songName, Types.LONGVARCHAR);

            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        ;

    }

    public void updateSong(Integer songId, byte[] songName) throws SQLException {
        String SQL_QUERY = "INSERT INTO songs (id,name) VALUES (?,?)";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jazz", "jazz", "allwedoisjazz");
             PreparedStatement pst = conn.prepareStatement(SQL_QUERY)) {
            pst.setInt(1, songId);
            pst.setBytes(2, songName);
            //pst.setObject(2,songName, Types.LONGVARCHAR);

            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        ;
    }
}

//try (Connection con = DataSource.getConnection();
//        PreparedStatement pst = con.prepareStatement(SQL_QUERY);
//        //Object row = pst.executeUpdate();
//        ResultSet rs = pst.executeUpdate();) {
//        while (rs.next()) {
//        result= rs.getString(String.valueOf(songName));
//        System.out.println(result);
//        }
//        }