package com.dinhtrongdat.chartdraw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> visitors = new ArrayList<>();
        visitors.add(new BarEntry(2, getIntent().getIntExtra("t2",0)));
        visitors.add(new BarEntry(3,getIntent().getIntExtra("t3",0)));
        visitors.add(new BarEntry(4,getIntent().getIntExtra("t4",0)));
        visitors.add(new BarEntry(5,getIntent().getIntExtra("t5",0)));
        visitors.add(new BarEntry(6,getIntent().getIntExtra("t6",0)));
        visitors.add(new BarEntry(7,getIntent().getIntExtra("t7",0)));
        visitors.add(new BarEntry(8,getIntent().getIntExtra("cn",0)));

        BarDataSet barDataSet = new BarDataSet(visitors, "Chú thích");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Thống kê tình trạng điện");
        barChart.animateXY(2000,2000);
    }
}