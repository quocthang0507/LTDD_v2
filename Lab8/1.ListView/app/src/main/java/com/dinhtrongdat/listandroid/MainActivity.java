package com.dinhtrongdat.listandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] title = new String[]{"Android","IOS","Window Phone"};
    String[] contents = new String[]{
            "Day la he dieu hanh android",
            "Day la he dieu hanh IOS",
            "Day la he dieu hanh Window Phone"
    };
    int[] imgs = new int[]{
            R.drawable.android_dark,
            R.drawable.ios_dark,
            R.drawable.window_dark
    };
    ListView lvMain;
    TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initUI();
    }

    private void initUI() {
        lvMain = findViewById(R.id.lvMain);
        txtDisplay = findViewById(R.id.txtDisplay);
        ArrayList<Product> list = new ArrayList<>();
        for(int i = 0;i<title.length; i++){
            list.add(new Product(imgs[i], title[i], contents[i]));
        }
        ListViewAdapter adapter = new ListViewAdapter(list);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtDisplay.setText("Ban chon " + title[i]);
            }
        });
    }
}