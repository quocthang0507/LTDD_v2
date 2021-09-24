package com.dinhtrongdat.convertrbgcmy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Convert extends AppCompatActivity {

    SeekBar sbR,sbG,sbB;
    CardView cvRGB, cvCMY;
    TextView txtR, txtG, txtB;
    int RColor=0, GColor=0,BColor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        initUI();
    }

    private void initUI() {
        sbR = findViewById(R.id.sbRed);
        sbG = findViewById(R.id.sbGreen);
        sbB = findViewById(R.id.sbBlue);
        cvCMY = findViewById(R.id.cvCMY);
        cvRGB = findViewById(R.id.cvRGB);
        txtR = findViewById(R.id.lbRed);
        txtG = findViewById(R.id.lbGreen);
        txtB = findViewById(R.id.lbBlue);

        sbR.setMax(255);
        sbG.setMax(255);
        sbB.setMax(255);

        sbR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
                txtR.setText("R = " + i);
                RColor = i;
                int RGBcolor = Color.argb(255,RColor,GColor,BColor);
                int CMYColor = Color.argb(255,255-RColor,255-GColor,255-BColor);
                cvRGB.setCardBackgroundColor(RGBcolor);
                cvCMY.setCardBackgroundColor(CMYColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
                txtG.setText("G = " + i);
                GColor = i;
                int RGBcolor = Color.argb(255,RColor,GColor,BColor);
                int CMYColor = Color.argb(255,255-RColor,255-GColor,255-BColor);
                cvRGB.setCardBackgroundColor(RGBcolor);
                cvCMY.setCardBackgroundColor(CMYColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
                txtB.setText("B = " + i);
                BColor = i;
                int RGBcolor = Color.argb(255,RColor,GColor,BColor);
                int CMYColor = Color.argb(255,255-RColor,255-GColor,255-BColor);
                cvRGB.setCardBackgroundColor(RGBcolor);
                cvCMY.setCardBackgroundColor(CMYColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}