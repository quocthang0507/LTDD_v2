package com.dinhtrongdat.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgRabbit,imgCat;
    Button btnOff, btnOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }
    private void initUI(){
        imgRabbit = (ImageView) findViewById(R.id.iv_rabbit);
        imgCat = (ImageView) findViewById(R.id.iv_cat);
        imgRabbit.setOnClickListener(this);
        imgCat.setOnClickListener(this);
        btnOn = (Button) findViewById(R.id.btn_on);
        btnOff = (Button) findViewById(R.id.btn_off);
        btnOn.setOnClickListener(this);
        btnOff.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_rabbit:
                startActivity(new Intent(MainActivity.this, act_detail_rabbit.class));
                break;
            case R.id.iv_cat:
                startActivity(new Intent(MainActivity.this, act_detail_cat.class));
                break;
            case R.id.btn_on:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                break;
            case R.id.btn_off:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            default:
                break;
        }
    }
}