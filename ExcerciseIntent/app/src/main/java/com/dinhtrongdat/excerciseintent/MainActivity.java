package com.dinhtrongdat.excerciseintent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {


    public static ArrayList<String> arrName;
    ImageView imgGoc, imgNhan;
    int REQUEST_IMG = 123;
    String tenHinhGoc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgGoc = (ImageView) findViewById(R.id.img_qt);
        imgNhan = (ImageView) findViewById(R.id.img_chon);

        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrName = new ArrayList<>(Arrays.asList(mangTen));

        Collections.shuffle(arrName);
        tenHinhGoc = arrName.get(5);

        int idHinh = getResources().getIdentifier(arrName.get(5), "drawable", getPackageName());

        imgGoc.setImageResource(idHinh);

        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,ImageActivity.class),REQUEST_IMG);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMG && resultCode == RESULT_OK && data != null){
            String tenHinhNhan = data.getStringExtra("tenhinhchon");
            int idHinhNhan = getResources().getIdentifier(tenHinhNhan, "drawable", getPackageName());
            imgNhan.setImageResource(idHinhNhan);

            if(tenHinhGoc.equals(tenHinhNhan)){
                Toast.makeText(MainActivity.this, "Corect",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Fail",Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.menu_reload){
            Collections.shuffle(arrName);
            tenHinhGoc = arrName.get(5);

            int idHinh = getResources().getIdentifier(arrName.get(5), "drawable", getPackageName());

            imgGoc.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }
}