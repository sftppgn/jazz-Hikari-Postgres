package com.tabs;

public class XmlDatabase {
    private String configFile;
    private String songId;
    private String[] notes;

    public void setFile(String configFile){
        this.configFile = configFile;
    }
    public void writeSong(String songId){
        //set songId
        this.songId = songId;
        this.notes = notes;

    }

    public Boolean checkSongId(String songId){
        //check database for songid
       return Boolean.FALSE;
    }
}
