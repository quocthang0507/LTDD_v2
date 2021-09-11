package com.dinhtrongdat.baitap2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class MultiLanguages extends AppCompatActivity {

    ImageButton btnUS, btnVN, btnFR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_languages);
        initUI();
    }
    private void initUI(){
        btnUS = (ImageButton) findViewById(R.id.btn_us);
        btnVN = (ImageButton) findViewById(R.id.btn_vn);
        btnFR = (ImageButton) findViewById(R.id.btn_fr);

        btnFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage("fr","FR");
            }
        });
        btnVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage("vi","VN");
            }
        });
        btnUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage("en","US");
            }
        });
    }

    public void changeLanguage(String language, String lan){
        Locale locale = new Locale(language,lan);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(
                config, getBaseContext().getResources().getDisplayMetrics()
        );
        Intent intent = new Intent(MultiLanguages.this, MultiLanguages.class);
        startActivity(intent);
        finish();
    }
}