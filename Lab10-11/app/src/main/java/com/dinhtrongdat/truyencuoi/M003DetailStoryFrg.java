package com.dinhtrongdat.truyencuoi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.dinhtrongdat.truyencuoi.adapter.DetailStoryAdapter;
import com.dinhtrongdat.truyencuoi.adapter.StoryAdapter;
import com.dinhtrongdat.truyencuoi.model.StoryEntity;

import java.util.ArrayList;

public class M003DetailStoryFrg extends Fragment {

    private TextView txtName, txtContent;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ite_detail_story, container, false);

        txtName = rootView.findViewById(R.id.tv_name);
        txtContent = rootView.findViewById(R.id.tv_content);

        Bundle bundle = getArguments();
        if(bundle != null){
            StoryEntity storyEntity = (StoryEntity) bundle.get("story");
            if(storyEntity!=null){
                txtName.setText(storyEntity.getName());
                txtContent.setText(storyEntity.getContent());
            }
        }
        return rootView;
    }

}
