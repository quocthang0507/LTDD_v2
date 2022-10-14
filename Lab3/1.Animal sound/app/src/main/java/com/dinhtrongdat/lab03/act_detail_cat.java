package com.dinhtrongdat.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class act_detail_cat extends AppCompatActivity {

    ImageView iv_faforite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_detail_cat);

        iv_faforite = (ImageView) findViewById(R.id.iv_favorite);
        iv_faforite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_faforite.setImageResource(R.drawable.ic_heart_full);
            }
        });
    }
}