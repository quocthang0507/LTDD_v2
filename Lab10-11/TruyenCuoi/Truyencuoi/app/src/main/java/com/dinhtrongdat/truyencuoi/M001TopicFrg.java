package com.dinhtrongdat.truyencuoi;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinhtrongdat.truyencuoi.adapter.TopicAdapter;
import com.dinhtrongdat.truyencuoi.model.Topic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class M001TopicFrg extends Fragment implements TopicAdapter.ListItemClickListener {

    private Context mContext;
    RecyclerView topicRecycle;
    RecyclerView.Adapter topicAdapter;
    private ArrayList<Topic> mdata;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m001_frg_topic, container, false);
        topicRecycle = rootView.findViewById(R.id.rvTopic);
        initUI(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initUI(View view) {
//        LinearLayout lnMain = view.findViewById(R.id.ln_Topic);
//        lnMain.removeAllViews();
        try{
            topicRecycle.setLayoutManager(new LinearLayoutManager(mContext));
            mdata = new ArrayList<>();
            String[] listItem = mContext.getAssets().list("photo");

            for(String fileName : listItem){
                String name = fileName.substring(0, fileName.indexOf("."));

                mdata.add(new Topic(BitmapFactory.decodeStream(mContext.getAssets().open("photo/" + fileName)),name));
            }

            topicAdapter = new TopicAdapter(mdata, this);
            topicAdapter.notifyDataSetChanged();
            topicRecycle.setAdapter(topicAdapter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTopicListClick(int clickedItemIndex) {

    }
}
