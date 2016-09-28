package com.example.dilippashi.rhythm.Adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.dilippashi.rhythm.Fragments.AlbumFragment;
import com.example.dilippashi.rhythm.Fragments.ArtistFragment;
import com.example.dilippashi.rhythm.Fragments.FolderFragment;
import com.example.dilippashi.rhythm.Fragments.PlaylistFragment;
import com.example.dilippashi.rhythm.Fragments.SongFragment;

/**
 * Created by Dilippashi on 05-08-2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PlaylistFragment Playlists = new PlaylistFragment();
                return Playlists;
            case 1:
                SongFragment Songs = new SongFragment();
                return Songs;
            case 2:
                AlbumFragment Album = new AlbumFragment();
                return Album;
            case 3:
                ArtistFragment Artist = new ArtistFragment();
                return Artist;
            case 4:
                FolderFragment Folders = new FolderFragment();
                return Folders;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}