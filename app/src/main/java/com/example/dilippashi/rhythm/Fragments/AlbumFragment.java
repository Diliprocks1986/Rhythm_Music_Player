package com.example.dilippashi.rhythm.Fragments;


import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dilippashi.rhythm.Adapters.AlbumAdapter;
import com.example.dilippashi.rhythm.DataModel.Album;
import com.example.dilippashi.rhythm.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Dilippashi on 05-08-2016.
 */
public class AlbumFragment extends Fragment {
    private ArrayList<Album> albumList;
    ListView albumView;
    ContentResolver musicResolver;
    Uri musicUri;
    Cursor musicCursor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album, container, false);
        albumView = (ListView) view.findViewById(R.id.album_list);
        albumList = new ArrayList<>();
        getAlbumList();
        //sort the data so that the songs are presented alphabetically
        Collections.sort(albumList, new Comparator<Album>() {
            public int compare(Album a, Album b) {
                return a.getAlbumName().compareTo(b.getAlbumName());
            }
        });
        AlbumAdapter albumAdt = new AlbumAdapter(this.getActivity(), albumList);
        albumView.setAdapter(albumAdt);
        return view;
    }

    private void getAlbumList() {
        //ContentResolver instance, retrieve the URI for external music files,
        //create a Cursor instance using the ContentResolver instance to query the music files
        musicResolver = getActivity().getContentResolver();
        musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        musicCursor = musicResolver.query(musicUri, null, null, null, null);
        //retrieve the column indexes for the data items that we are interested in for each song
        if (musicCursor != null && musicCursor.moveToFirst()) {
            //get columns
            int albumId = musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
            int albumName = musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            int artistName = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.ARTIST);
           // int songNumber = musicCursor.getColumnIndex(MediaStore.Audio.Albums.NUMBER_OF_SONGS);
            int year = musicCursor.getColumnIndex(MediaStore.Audio.Media.YEAR);
            //add songs to list
            do {
                long thisId = musicCursor.getLong(albumId);
                String thisAlbum = musicCursor.getString(albumName);
                String thisArtist = musicCursor.getString(artistName);
                //int thisSongNumber = musicCursor.getInt(songNumber);
                String thisYear= musicCursor.getString(year);
                albumList.add(new Album(thisId, thisAlbum, thisArtist, thisYear));
            }
            while (musicCursor.moveToNext());

        }
    }
}
