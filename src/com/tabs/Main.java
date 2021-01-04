package com.tabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tabs.Database.ConnectTest;
import com.tabs.Database.DataSource;

import java.lang.Class.*;
import java.sql.*;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException {
        String fullUrl;
        String result;
        String songLine;

        //fullUrl = "https://www.songsterr.com/a/wsa/metallica-a-tribute-to-kirk-hammett-tab-s64590t0";
        //ReadWebPage page1 = new ReadWebPage();

        //System.out.print(page1.getUrl("https://www.songsterr.com/a/wsa/metallica-a-tribute-to-kirk-hammett-tab-s64590t0"));
        //result = page1.getUrl(fullUrl);


        //AltoSaxTranspose song = new AltoSaxTranspose();
        //songLine = song.setSongLine(result);
        //System.out.println(song.setLilyFile(result));

        //XmlDatabase = new XmlDatabase();
        //System.out.print(writer.writeSong(songLine));

        //StatxWriter writer = new StatxWriter();
        //writer.writeSong(songLine);

//        ConnectTest dbConnection = new ConnectTest();
//        String url = "jdbc:postgresql://localhost:5432/jazz";
//        String user = "jazz";
//        String password = "allwedoisjazz";
//        System.out.println(dbConnection.connect(url, user, password));

        DataSource ds = new DataSource();
        String songNameStr = "test8";
        byte[] songName = songNameStr.getBytes();
        //ds.writeSong(8,songName);
        ds.fetchData("id");






    }
}
