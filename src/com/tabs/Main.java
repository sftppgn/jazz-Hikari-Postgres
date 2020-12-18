package com.tabs;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String fullUrl;
        String result;
        String songLine;

        fullUrl = "https://www.songsterr.com/a/wsa/metallica-a-tribute-to-kirk-hammett-tab-s64590t0";
        ReadWebPage page1 = new ReadWebPage();

        //System.out.print(page1.getUrl("https://www.songsterr.com/a/wsa/metallica-a-tribute-to-kirk-hammett-tab-s64590t0"));
        result = page1.getUrl(fullUrl);


        AltoSaxTranspose song = new AltoSaxTranspose();
        songLine = song.setSongLine(result);
        //System.out.println(song.setLilyFile(result));

        //XmlDatabase = new XmlDatabase();
        StatxWriter writer = new StatxWriter();
        //System.out.print(writer.writeSong(songLine));
        writer.writeSong(songLine);
    }
}
