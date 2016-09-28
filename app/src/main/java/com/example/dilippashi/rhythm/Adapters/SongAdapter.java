package com.example.dilippashi.rhythm.Adapters;

/**
 * Created by Dilippashi on 06-08-2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dilippashi.rhythm.DataModel.Artist;
import com.example.dilippashi.rhythm.R;
import com.example.dilippashi.rhythm.DataModel.Song;

import java.util.ArrayList;

public class SongAdapter extends BaseAdapter {
    private ArrayList<Song> songList;
    private LayoutInflater songInf;

    public class ViewHolder {
        public TextView songName,AlbumName,ArtistName;
    }


    public SongAdapter(Context c, ArrayList<Song> psongs) {
        songList = psongs;
        songInf = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            // inflate the layout
            convertView = songInf.inflate(R.layout.song, parent, false);
            viewHolder = new ViewHolder();
            //get title, album and artist views
            viewHolder.songName = (TextView) convertView.findViewById(R.id.song_title);
            viewHolder.AlbumName = (TextView) convertView.findViewById(R.id.song_album);
            viewHolder.ArtistName = (TextView) convertView.findViewById(R.id.song_artist);

            convertView.setTag(viewHolder);
        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //get song using position
        Song currSong = songList.get(position);
        //get title and artist strings
        if (currSong != null) {
        // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            viewHolder.songName.setText(currSong.getTitle());
            viewHolder.AlbumName.setText(currSong.getAlbum());
            viewHolder.ArtistName.setText(currSong.getArtist());
        }

        return convertView;

    }
}