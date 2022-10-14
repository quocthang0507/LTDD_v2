package com.dinhtrongdat.chartdraw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class drawChart extends AppCompatActivity {

    private ArrayList<BarEntry> visitor = new ArrayList<>();
    private EditText txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_chart);

        initUI();
    }

    private void initUI() {
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);

        findViewById(R.id.btnDraw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(drawChart.this, BarChartAct.class);
                intent.putExtra("t2",Integer.parseInt(txt1.getText().toString()));
                intent.putExtra("t3",Integer.parseInt(txt2.getText().toString()));
                intent.putExtra("t4",Integer.parseInt(txt3.getText().toString()));
                intent.putExtra("t5",Integer.parseInt(txt4.getText().toString()));
                intent.putExtra("t6",Integer.parseInt(txt5.getText().toString()));
                intent.putExtra("t7",Integer.parseInt(txt6.getText().toString()));
                intent.putExtra("cn",Integer.parseInt(txt7.getText().toString()));

                startActivity(intent);
            }
        });

        findViewById(R.id.btnDrawPie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(drawChart.this, PieChartAct.class);
                intent.putExtra("t2",Integer.parseInt(txt1.getText().toString()));
                intent.putExtra("t3",Integer.parseInt(txt2.getText().toString()));
                intent.putExtra("t4",Integer.parseInt(txt3.getText().toString()));
                intent.putExtra("t5",Integer.parseInt(txt4.getText().toString()));
                intent.putExtra("t6",Integer.parseInt(txt5.getText().toString()));
                intent.putExtra("t7",Integer.parseInt(txt6.getText().toString()));
                intent.putExtra("cn",Integer.parseInt(txt7.getText().toString()));

                startActivity(intent);
            }
        });
    }

}