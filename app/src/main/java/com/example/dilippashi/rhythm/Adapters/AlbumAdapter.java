package com.example.dilippashi.rhythm.Adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dilippashi.rhythm.DataModel.Album;
import com.example.dilippashi.rhythm.R;
import java.util.ArrayList;

/**
 * Created by Dilippashi on 09-08-2016.
 */



public class AlbumAdapter extends BaseAdapter {
    private ArrayList<Album> albumList;
    private LayoutInflater albumInf;

    public class ViewHolder {

        public TextView AlbumName;
        public TextView Artists;
        public TextView year;

    }

    public AlbumAdapter(Context c, ArrayList<Album> palbumList) {
        albumList = palbumList;
        albumInf = LayoutInflater.from(c);

    }

    @Override
    public int getCount() {
        return albumList.size();
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
            convertView = albumInf.inflate(R.layout.album, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.AlbumName = (TextView) convertView.findViewById(R.id.AlbumName);
            viewHolder.Artists = (TextView) convertView.findViewById(R.id.Artists);
            viewHolder.year = (TextView) convertView.findViewById(R.id.year);
            convertView.setTag(viewHolder);
        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //get song using position
        Album currAlbum = albumList.get(position);

        if (currAlbum != null) {
            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            viewHolder.AlbumName.setText(currAlbum.getAlbumName());
            viewHolder.Artists.setText(currAlbum.getArtistName());
            viewHolder.year.setText(currAlbum.getYear());
        }

        return convertView;

    }
}



