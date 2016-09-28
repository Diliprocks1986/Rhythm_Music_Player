package com.example.dilippashi.rhythm.Fragments;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dilippashi.rhythm.Adapters.AlbumAdapter;
import com.example.dilippashi.rhythm.Adapters.ArtistAdapter;
import com.example.dilippashi.rhythm.DataModel.Album;
import com.example.dilippashi.rhythm.DataModel.Artist;
import com.example.dilippashi.rhythm.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Dilippashi on 05-08-2016.
 */
public class ArtistFragment extends Fragment {
    private ArrayList<Artist> artistList;
    ListView artistView;
    ContentResolver musicResolver;
    Uri musicUri;
    Cursor musicCursor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_artist, container, false);
        artistView = (ListView) view.findViewById(R.id.artist_list);
        artistList = new ArrayList<>();
        getAlbumList();
        //sort the data so that the songs are presented alphabetically
        Collections.sort(artistList, new Comparator<Artist>() {
            public int compare(Artist a, Artist b) {
                return a.getArtistName().compareTo(b.getArtistName());
            }
        });
        ArtistAdapter ArtistAdt = new ArtistAdapter(this.getActivity(), artistList);
        artistView.setAdapter(ArtistAdt);
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
            int artistId = musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
            final String artistart = MediaStore.Audio.Albums.ALBUM_ART;
            int artistName = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.ARTIST);
            int albumName = musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);

            // int songNumber = musicCursor.getColumnIndex(MediaStore.Audio.Albums.NUMBER_OF_SONGS);
            int year = musicCursor.getColumnIndex(MediaStore.Audio.Media.YEAR);
            //add songs to list
            do {
                long thisId = musicCursor.getLong(artistId);
                //String artPath = musicCursor.getString(musicCursor.getColumnIndex(artistart));
                // Bitmap art = BitmapFactory.decodeFile(artPath);
                String thisArtist = musicCursor.getString(artistName);
                String thisAlbum = musicCursor.getString(albumName);

                //int thisSongNumber = musicCursor.getInt(songNumber);
                String thisYear= musicCursor.getString(year);
                artistList.add(new Artist(thisId, thisArtist, thisAlbum,  thisYear));
            }
            while (musicCursor.moveToNext());

        }
    }

}

