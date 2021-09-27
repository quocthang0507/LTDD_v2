package com.dinhtrongdat.customgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class act_customgrid extends AppCompatActivity {

    private GridView gvRap;
    ArrayList<Genius> arrRap;
    CustomAdapterGridView adapter;
    String[] title = new String[]{"Maboo","Brandon","BBDS","SameOldShawn","Clement_RGF","TheDarkKnight","Nenja","Dlizze","Hellrel"};
    int[] img = new int[]{R.drawable.entertainment,R.drawable.hotel,R.drawable.location_shop_online_icon_192424,
    R.drawable.medical,R.drawable.restaurant, R.drawable.store, R.drawable.time,R.drawable.traveling,R.drawable.work};
    double[] number = new double[]{283297,100466,123456,109857,189475,10948474,12345,345256,123456};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_customgrid);

        gvRap = findViewById(R.id.gridView);
        arrRap = new ArrayList<>();
        for(int i=0;i<title.length;i++){
            arrRap.add(new Genius(img[i],title[i],number[i]));
        }
        adapter = new CustomAdapterGridView(arrRap,this);
        gvRap.setAdapter(adapter);
    }
}
