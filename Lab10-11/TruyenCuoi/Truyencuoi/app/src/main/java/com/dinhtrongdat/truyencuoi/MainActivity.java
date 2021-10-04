package com.dinhtrongdat.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;

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

    }

    public void backToM001Screen() {
        gotoM001Screen();
    }
}