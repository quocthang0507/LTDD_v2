package com.dinhtrongdat.truyencuoi.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.dinhtrongdat.truyencuoi.M003DetailStoryFrg;
import com.dinhtrongdat.truyencuoi.R;
import com.dinhtrongdat.truyencuoi.model.StoryEntity;

import org.w3c.dom.Text;

import java.util.List;

public class DetailStoryAdapter extends FragmentStatePagerAdapter {
    private List<StoryEntity> listStory;

    public DetailStoryAdapter(FragmentManager fm, int behavior,List<StoryEntity> listStory) {
        super(fm, behavior);
        this.listStory = listStory;
    }

    @Override
    public Fragment getItem(int position) {
        if(listStory == null || listStory.isEmpty()){
            return null;
        }
        StoryEntity storyEntity = listStory.get(position);
        M003DetailStoryFrg frg = new M003DetailStoryFrg();
        Bundle bundle = new Bundle();
        bundle.putSerializable("story",storyEntity);
        frg.setArguments(bundle);
        return frg;
    }

    @Override
    public int getCount() {
        return listStory.size();
    }
}
