package com.dinhtrongdat.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dinhtrongdat.truyencuoi.adapter.StoryAdapter;
import com.dinhtrongdat.truyencuoi.model.StoryEntity;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class StoryAct extends AppCompatActivity implements StoryAdapter.ListItemClickListener {

//    String[] name = {"Việc học","Đã hai lần rồi","Cũng như nhau","Rất lạnh","Im lặng là vàng","Bài học về tội nói dối","Chưa chi đã đau",
//            "1 xu và 1 phút","Sao còn chưa thả","Di tích hóa thạch","Nhầm lẫn tai hại","Cảnh giác","Chào cô! Bố em","Chưa nấu đã chín"};
//
//    int[] content = {(R.string.story1),(R.string.story2),(R.string.story3),(R.string.story4),(R.string.story5),
//            (R.string.story6),(R.string.story7),(R.string.story8),(R.string.story9),(R.string.story10),
//            (R.string.story11),(R.string.story12),(R.string.story13),(R.string.story14)};

    private RecyclerView storyRecycle;
    private RecyclerView.Adapter storyAdapter;
    private ArrayList<StoryEntity> mdata;
    private String topicName;
    private ImageView imgBack;
    private TextView ttxtNameTopic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        storyRecycle = findViewById(R.id.rv_story);
        initUI();
    }

    private void initUI() {
        imgBack = findViewById(R.id.iv_back);
        ttxtNameTopic = findViewById(R.id.tv_name_topic);
        ttxtNameTopic.setText(topicName);
        topicName = getIntent().getStringExtra("topic_name");
        storyRecycle.setLayoutManager(new LinearLayoutManager(this));
        mdata = new ArrayList<>();
//        for(int i=0; i<name.length; i++){
//            mdata.add(new StoryEntity(topicName,name[i],getString(content[i])));
//        }
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(this.getAssets().open("story/"+topicName+".txt"),"UTF-8"));
            String line = "";
            do{
                String title = reader.readLine();
                if(title == null) break;

                String content = "";
                do{
                    line = reader.readLine();
                    content+=line+"\n";
                }while (!line.contains("','0');"));
                content = content.replace("','0');", "");
                StoryEntity storyEntity = new StoryEntity(topicName,title,content);
                mdata.add(storyEntity);
            }while (line!=null);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        storyAdapter = new StoryAdapter(mdata, this);
        storyAdapter.notifyDataSetChanged();
        storyRecycle.setAdapter(storyAdapter);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StoryAct.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onStoryListClick(int clickedItemIndex) {
        Intent intent = new Intent(this,DetailStoryAct.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("current_data",mdata.get(clickedItemIndex));
        intent.putExtra("topic",mdata.get(clickedItemIndex).getTopicName());
        bundle.putSerializable("data", mdata);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}