package com.dinhtrongdat.truyencuoi;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinhtrongdat.truyencuoi.adapter.StoryAdapter;
import com.dinhtrongdat.truyencuoi.model.StoryEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M002StoryFrg extends Fragment{
    private Context mContext;
    private RecyclerView storyRecycle;
    private RecyclerView.Adapter storyAdapter;
    private ArrayList<StoryEntity> mdata;
    private String topicName;

    public M002StoryFrg(String topicName){
        this.topicName = topicName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m002_frg_story, container, false);
        storyRecycle = rootView.findViewById(R.id.rv_story);

        try {
            initUI(rootView);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initUI(View view) throws IOException {
        try {
            storyRecycle.setLayoutManager(new LinearLayoutManager(mContext));
            mdata = new ArrayList<>();
            String item = topicName + ".txt";


            InputStream is = mContext.getAssets().open("story/" + item);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            ArrayList<String> listContent = new ArrayList<>();
            String line = reader.readLine();;
            while (line!=null) {
                line = reader.readLine();
                StringTokenizer myTokens = new StringTokenizer(line, ";");
                while (myTokens.hasMoreTokens()) {
                    listContent.add(myTokens.nextToken());
                }
            }
            reader.close();
            for (String content : listContent) {
                    String name = content.substring(0, content.indexOf("\\n"));
                    mdata.add(new StoryEntity(topicName, name, content));
            }
            storyAdapter = new StoryAdapter(mdata, mContext);
            storyAdapter.notifyDataSetChanged();
            storyRecycle.setAdapter(storyAdapter);

        } catch (IOException e) {
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
