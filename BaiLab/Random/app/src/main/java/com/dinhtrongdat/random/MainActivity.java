package com.dinhtrongdat.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrName;
    ImageView imgDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        imgDice = (ImageView) findViewById(R.id.imgView);

        String[] mangTen = getResources().getStringArray(R.array.arr_dice);
        arrName = new ArrayList<>(Arrays.asList(mangTen));

        Collections.shuffle(arrName);
        int idHinh = getResources().getIdentifier(arrName.get(3),"drawable", getPackageName());
        imgDice.setImageResource(idHinh);

        imgDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(arrName);
                int idHinh = getResources().getIdentifier(arrName.get(3),"drawable", getPackageName());
                imgDice.setImageResource(idHinh);
            }
        });
    }
}