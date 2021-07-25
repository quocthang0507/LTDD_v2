package com.dinhtrongdat.ungdungdautien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String hoten = "Dinh Trong Dat";
        Log.d("TRONGDAT", hoten);
    }
}