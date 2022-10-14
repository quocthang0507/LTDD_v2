package com.dinhtrongdat.canvasandmultithresh;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    MyCanvas canvas;
    Button btnDraw;
    int[] colors = new int[]{Color.RED, Color.GREEN, Color.GRAY, Color.YELLOW, Color.CYAN, Color.WHITE};
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvas = findViewById(R.id.myCanvas);
        btnDraw = findViewById(R.id.btnDraw);
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int colorIndex = rand.nextInt(colors.length);
                MyCanvas.color = colors[colorIndex];
                canvas.invalidate();
            }
        });

    }

}