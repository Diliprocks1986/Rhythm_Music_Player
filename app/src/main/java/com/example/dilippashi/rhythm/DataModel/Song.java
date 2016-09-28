package com.example.dilippashi.rhythm.DataModel;

/**
 * Created by Dilippashi on 06-08-2016.
 */
public class Song {
    private long mId;
    private String mTitle;
    private String mArtist;
    private String mAlbum;

    //SETTER Method
    public Song(long id, String Title, String Artist, String Album) {
        mId = id;
        mTitle = Title;
        mArtist = Artist;
        mAlbum = Album;

    }

    //GETTER Methods
    public long getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getAlbum() {
        return mAlbum;
    }

}
