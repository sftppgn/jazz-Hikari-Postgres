package com.tabs;

import java.io.IOError;
import java.io.IOException;
import java.util.regex.Pattern;

public class AltoSaxTranspose {

    private String tempFileName;
    private String finalFileName;
    private Pattern songNamePattern = Pattern.compile("name.*songId");

    public String setSongLine(String webUrl) {
        //finalFileName = webUrl.toString();
        //tempFileName = webUrl.toString();

        String[] urlLines = webUrl.split("\\<", -1);

        for (String val : urlLines) {
            //System.out.println("value "+val);
                if (val.contains("songId")) {
                    //todo: other checks and logic to verify we have what we expect.
                    return val;
                }


        }
return "No Song Id";
    }
}
