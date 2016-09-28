package com.example.dilippashi.rhythm.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dilippashi.rhythm.DataModel.Album;
import com.example.dilippashi.rhythm.DataModel.Artist;
import com.example.dilippashi.rhythm.R;

import java.util.ArrayList;

/**
 * Created by Dilippashi on 10-08-2016.
 */
public class ArtistAdapter extends BaseAdapter {
    private ArrayList<Artist> artistList;
    private LayoutInflater artistInf;

    public class ViewHolder {
        public TextView ArtistName,AlbumName,year;
    }

    public ArtistAdapter(Context c, ArrayList<Artist> partistList) {
        artistList = partistList;
        artistInf = LayoutInflater.from(c);

    }
    @Override
    public int getCount() {
        return artistList.size();
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
            convertView = artistInf.inflate(R.layout.artist, parent, false);

            viewHolder = new ViewHolder();
        //get title, album and artist views
        //ImageView AlbumArt = (ImageView) AlbumLayout.findViewById(R.id.ArtistArt);
            viewHolder.ArtistName = (TextView) convertView.findViewById(R.id.ArtistName);
            viewHolder.AlbumName = (TextView) convertView.findViewById(R.id.AlbumNam);
            viewHolder.year = (TextView) convertView.findViewById(R.id.year);
            convertView.setTag(viewHolder);
        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //get song using position
        Artist currArtist = artistList.get(position);
        //get title and artist strings
        if (currArtist != null) {
            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            viewHolder.ArtistName.setText(currArtist.getArtistName());
            viewHolder.AlbumName.setText(currArtist.getAlbumName());
            viewHolder.year.setText(currArtist.getYear());
        }

        return convertView;

    }
}

