package com.example.dilippashi.rhythm.Fragments;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dilippashi.rhythm.R;
import com.example.dilippashi.rhythm.DataModel.Song;
import com.example.dilippashi.rhythm.Adapters.SongAdapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Dilippashi on 05-08-2016.
 */
public class SongFragment extends Fragment {
    private ArrayList<Song> songList;
    ListView songView;
    ContentResolver musicResolver;
    Uri musicUri;
    Cursor musicCursor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song, container, false);
        songView = (ListView) view.findViewById(R.id.song_list);
        songList = new ArrayList<>();
        getSongList();
        //sort the data so that the songs are presented alphabetically
        Collections.sort(songList, new Comparator<Song>() {
            public int compare(Song a, Song b) {
                return a.getTitle().compareTo(b.getTitle());
            }
        });
        SongAdapter songAdt = new SongAdapter(this.getActivity(), songList);
        songView.setAdapter(songAdt);
        return view;
    }
    public void getSongList() {
        //ContentResolver instance, retrieve the URI for external music files,
        //create a Cursor instance using the ContentResolver instance to query the music files
            musicResolver = getActivity().getContentResolver();
        musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        musicCursor = musicResolver.query(musicUri, null, null, null, null);
        //retrieve the column indexes for the data items that we are interested in for each song
        if (musicCursor != null && musicCursor.moveToFirst()) {
            //get columns
            int title = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.TITLE);
            int id = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media._ID);
            int artist = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.ARTIST);
                int album = musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            //add songs to list
            do {
                long thisId = musicCursor.getLong(id);
                String thisTitle = musicCursor.getString(title);
                String thisArtist = musicCursor.getString(artist);
                String thisAlbum = musicCursor.getString(album);
                songList.add(new Song(thisId, thisTitle, thisArtist, thisAlbum));
            }
            while (musicCursor.moveToNext());

        }
    }
}
