package com.tabs;

public class Song {

    private String songId;
    private String[] notes;

    public String getSongId() {
        return songId;
    }

    public String[] getNotes() {
        return notes;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public void setNotes(String[] notes) {
        this.notes = notes;
    }

   @Override
   public String toString(){
        return (this.songId + this.notes);
   }

}
