package com.dinhtrongdat.truyencuoi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.dinhtrongdat.truyencuoi.adapter.DetailStoryAdapter;
import com.dinhtrongdat.truyencuoi.adapter.StoryAdapter;
import com.dinhtrongdat.truyencuoi.model.StoryEntity;

import java.util.ArrayList;

public class M003DetailStoryFrg extends Fragment {
    private Context mContext;
    private ArrayList<StoryEntity> listStory;
    private String topicName;
    private StoryEntity currentStory;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m003_frg_detail_story, container, false);
        initUI(rootView);
        return rootView;
    }

    private void initUI(View view) {
        view.findViewById(R.id.iv_back).setVisibility(View.VISIBLE);
        view.findViewById(R.id.iv_back).setOnClickListener(view1 -> gotoM002Screen(topicName));
        view.findViewById(R.id.vp_story);
        ViewPager vp = view.findViewById(R.id.vp_story);
        DetailStoryAdapter adapter = new DetailStoryAdapter(listStory, mContext);
        vp.setAdapter(adapter);
        vp.setCurrentItem(listStory.indexOf(currentStory), true);
    }

    private void backToM001Screen(){
        ((MainActivity)getActivity()).backToM001Screen();
    }

    private void gotoM002Screen(String topicName) {
    }
    public void setData(String topicName, ArrayList<StoryEntity> listStory, StoryEntity currentStory){
        this.currentStory = currentStory;
        this.topicName = topicName;
        this.listStory = listStory;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

}
