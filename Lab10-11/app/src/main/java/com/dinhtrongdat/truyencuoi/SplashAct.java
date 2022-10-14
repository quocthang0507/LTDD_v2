package com.dinhtrongdat.truyencuoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashAct extends AppCompatActivity {

    LottieAnimationView splash;
    TextView txtName, txtDes;
    Animation animDes, animLayout, animName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash2);

        initUI();
    }

    private void initUI() {
        splash = findViewById(R.id.splash_main);
        txtName = findViewById(R.id.txtName);
        txtDes = findViewById(R.id.txt_description);

        animDes = AnimationUtils.loadAnimation(this, R.anim.anim_fall_down);
        animName = AnimationUtils.loadAnimation(this, R.anim.anim_top);
        animLayout = AnimationUtils.loadAnimation(this, R.anim.anim_bot_to_top);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splash.setVisibility(View.VISIBLE);
                splash.setAnimation(animLayout);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtName.setVisibility(View.VISIBLE);
                        txtDes.setVisibility(View.VISIBLE);

                        txtName.setAnimation(animName);
                        txtDes.setAnimation(animDes);
                    }
                }, 1000);
            }
        }, 500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashAct.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 6000);
    }
}
