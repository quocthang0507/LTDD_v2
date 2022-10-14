package com.dinhtrongdat.luyentap3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imgCall;
    TextView numberPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAndRequestPermission();
        Hook();
    }

    private void Hook(){
        imgCall = (ImageView) findViewById(R.id.img_call);
        numberPhone = (TextView) findViewById(R.id.number_phone);

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCall();
            }
        });
    }
    private void intentCall(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+numberPhone.getText()));
        startActivity(intent);
    }
    private void checkAndRequestPermission(){
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE
        };

        List<String> listPermissionNeed = new ArrayList<>();
        for(String permission : permissions){
            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
                listPermissionNeed.add(permission);
            }
        }
        if(!listPermissionNeed.isEmpty()){
            ActivityCompat.requestPermissions(this, listPermissionNeed.toArray(new String[listPermissionNeed.size()]),1);
        }
    }
}