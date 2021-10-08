package com.dinhtrongdat.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dinhtrongdat.truyencuoi.adapter.DetailStoryAdapter;
import com.dinhtrongdat.truyencuoi.model.StoryEntity;

import java.util.ArrayList;
import java.util.List;

public class DetailStoryAct extends AppCompatActivity {

    private ViewPager viewPager;
    ImageView imgBack;
    private TextView ttxtNameTopic;
    DetailStoryAdapter detailStoryAdapter;
    ArrayList<StoryEntity> mdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_story);
        initUI();
    }

    private void initUI() {
        viewPager = findViewById(R.id.vp_story);
        imgBack = findViewById(R.id.iv_back);
        ttxtNameTopic = findViewById(R.id.tv_name_topic);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailStoryAct.this, StoryAct.class));
            }
        });

        ttxtNameTopic.setText(getIntent().getStringExtra("topic"));
        mdata = new ArrayList<>();
        mdata = (ArrayList<StoryEntity>) getIntent().getExtras().get("data");
        detailStoryAdapter = new DetailStoryAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mdata);
        detailStoryAdapter.notifyDataSetChanged();
        viewPager.setAdapter(detailStoryAdapter);
        viewPager.setCurrentItem(mdata.indexOf((StoryEntity) getIntent().getExtras().get("current_data")), true);
    }
}