package com.example.dilippashi.rhythm.DataModel;

/**
 * Created by Dilippashi on 10-08-2016.
 */
public class Artist {

    private long mAlbumId;
    //private Bitmap mAlbumImg;
    private String mArtistName;
    private String mAlbumName;
    //private int mSongNumber;
    private String mYear;

    //SETTER Method
    public Artist(long AlbumId, String ArtistName, String AlbumName,  String Year) {
        mAlbumId = AlbumId;
        //mAlbumImg = albumImg;
        mArtistName = ArtistName;
        mAlbumName =  AlbumName;
        // mSongNumber = SongNumber;
        mYear = Year;

    }

    //GETTER Methods
    public long getAlbumId() {
        return mAlbumId;
    }

    // public Bitmap getAlbumImage() {
    //     return mAlbumImg;
    // }
    public String getArtistName() {
        return mArtistName;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    //public int getSongNumber() {
    //  return mSongNumber;
    // }
    public String getYear() {
        return mYear;
    }
}


