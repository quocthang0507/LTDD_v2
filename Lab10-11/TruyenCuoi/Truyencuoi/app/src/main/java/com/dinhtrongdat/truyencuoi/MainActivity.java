package com.dinhtrongdat.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.dinhtrongdat.truyencuoi.adapter.StoryAdapter;
import com.dinhtrongdat.truyencuoi.adapter.TopicAdapter;
import com.dinhtrongdat.truyencuoi.model.StoryEntity;
import com.dinhtrongdat.truyencuoi.model.Topic;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TopicAdapter.ListItemClickListener {

    RecyclerView topicRecycle;
    RecyclerView.Adapter topicAdapter;
    private ArrayList<Topic> mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topicRecycle = findViewById(R.id.rvTopic);
        initUI();
    }

    private void initUI() {
        try{
            topicRecycle.setLayoutManager(new LinearLayoutManager(this));
            mdata = new ArrayList<>();
            String[] listItem = getAssets().list("photo");

            for(String fileName : listItem){
                String name = fileName.substring(0, fileName.indexOf("."));

                mdata.add(new Topic(BitmapFactory.decodeStream(this.getAssets().open("photo/" + fileName)),name));
            }

            topicAdapter = new TopicAdapter(mdata, this);
            topicAdapter.notifyDataSetChanged();
            topicRecycle.setAdapter(topicAdapter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void gotoM001Screen() {
    }

    public void backToM001Screen() {
        gotoM001Screen();
    }

    @Override
    public void onTopicListClick(int clickedItemIndex) {
        try {
            String[] listName = this.getAssets().list("story");
            String name = listName[clickedItemIndex];
            String topicName = name.substring(0, name.indexOf("."));

            Intent intent = new Intent(MainActivity.this, StoryAct.class);
            intent.putExtra("topic_name",topicName);
            startActivity(intent);
        } catch (IOException e) {
        }
    }
}