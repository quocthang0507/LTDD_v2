package com.dinhtrongdat.luyentap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrName;
    LinearLayout layout;
    Animation Anim;
    ImageView imgView;
    TextView txtView;
    ProgressBar progressBar;
    private static int SPLAS_SCREEN = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hook();
    }

    private void Hook(){
        Random random = new Random();
        imgView = (ImageView) findViewById(R.id.img_view);
        txtView = (TextView) findViewById(R.id.txt_view);
        layout = (LinearLayout) findViewById(R.id._layout);
        progressBar = (ProgressBar) findViewById(R.id.progess_bar);
//
//        String[] mangTen = getResources().getStringArray(R.array.arr_human);
//        arrName = new ArrayList<>(Arrays.asList(mangTen));
//
//        Collections.shuffle(arrName);
//        int idHinh = getResources().getIdentifier(arrName.get(2), "drawable", getPackageName());
//        imgView.setImageResource(idHinh);
//
        Anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        int color = Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));

        layout.setBackgroundColor(color);
        imgView.setAnimation(Anim);
        txtView.setAnimation(Anim);

        Sprite circle = new Circle();
        progressBar.setIndeterminateDrawable(circle);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        }, SPLAS_SCREEN);
    }
}