package com.dinhtrongdat.selectionexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] units = {
            "Android", "IOS", "WindowsPhone", "bOS", "Blackberry", "Symbian"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        Spinner spinner = (Spinner) findViewById(R.id.spn);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        TextView txtResult = (TextView) findViewById(R.id.txtResult);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, units
        );

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = gridView.getItemAtPosition(i);

                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                        MainActivity.this, android.R.layout.simple_list_item_1, Collections.singletonList(units[i])
                );

                gridView.setAdapter(adapter2);
                txtResult.setText(String.valueOf(units[i]));
            }
        });

    }

}