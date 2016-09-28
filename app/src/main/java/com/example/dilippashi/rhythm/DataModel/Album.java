package com.example.dilippashi.rhythm.DataModel;

/**
 * Created by Dilippashi on 09-08-2016.
 */


 public class Album {

    private long mAlbumId;
    private String mAlbumName;
    private String mArtistName;
    private String mYear;

    //SETTER Method
    public Album(long AlbumId, String AlbumName, String ArtistName, String Year) {
        mAlbumId = AlbumId;
        mAlbumName =  AlbumName;
        mArtistName = ArtistName;
        mYear = Year;

    }

    //GETTER Methods
    public long getAlbumId() {
        return mAlbumId;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public String getArtistName() {
        return mArtistName;
    }
    public String getYear() {
        return mYear;
    }
}




