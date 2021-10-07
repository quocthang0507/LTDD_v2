package com.dinhtrongdat.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.dinhtrongdat.truyencuoi.adapter.StoryAdapter;
import com.dinhtrongdat.truyencuoi.model.StoryEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String topicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        showFrg(new SplashActivity());
    }

    private void showFrg(Fragment splashActivity) {
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_Main, splashActivity, null).commit();
    }

    public void gotoM001Screen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_Main, new M001TopicFrg(), null).commit();
    }

    public void gotoM002Screen(String tag) {
        M002StoryFrg frg = new M002StoryFrg(tag);
//        Toast.makeText(this,tag,Toast.LENGTH_LONG).show();
        showFrg(frg);
    }

    public void backToM001Screen() {
        gotoM001Screen();
    }

    public void gotoM003Screen(ArrayList<StoryEntity> storyLocation, StoryEntity story) {
        M003DetailStoryFrg frg = new M003DetailStoryFrg();
        frg.setData(topicName,storyLocation, story);
    }
}