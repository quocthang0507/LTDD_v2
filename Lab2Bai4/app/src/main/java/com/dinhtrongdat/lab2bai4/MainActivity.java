package com.dinhtrongdat.lab2bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvPlanet;
    ArrayList<Planet> arrPlanet;
    CustomListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPlanet = (ListView) findViewById(R.id.listView);
        arrPlanet = new ArrayList<>();

        arrPlanet.add(new Planet("Mercury", "A small, rocky planet.", R.mipmap.mercury));
        arrPlanet.add(new Planet("Venus","A small, rocky planet blanketed in a thick layer of yellowwish cliusd", R.mipmap.vernus));
        arrPlanet.add(new Planet("Earth", "A small, rocky planet which support a variety of life!", R.mipmap.earth));

        adapter = new CustomListAdapter(arrPlanet, R.layout.list_item_layout, this);

        lvPlanet.setAdapter(adapter);
    }
}